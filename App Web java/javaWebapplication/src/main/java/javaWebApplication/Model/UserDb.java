package javaWebApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaWebApplication.Beans.Atendente;
import javaWebApplication.Beans.DiaSemana;
import javaWebApplication.Beans.HoraDia;
import javaWebApplication.Beans.LoginBean;
import javaWebApplication.Beans.Record;
import javaWebApplication.Beans.RecordId;
import javaWebApplication.Beans.RecordIdAlteration;
import javaWebApplication.Beans.RegisterBean;
import javaWebApplication.Beans.TipoServico;

public class UserDb {

	public String insertUser(RegisterBean user1) {

		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();

		String s1 = null;

		try {
			Statement stmt = (Statement) con.createStatement();
			stmt.executeUpdate("INSERT INTO USERS(userNome,userSobrenome,email,senha) values('" + user1.getNome()
					+ "','" + user1.getSobrenome() + "','" + user1.getEmail() + "','" + user1.getSenha() + "')");
			s1 = "Insert concluded";

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return s1;
	}

	public ResultSet autenticacaoUsuario(LoginBean user) {

		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;

		try {
			String sql = "select Email,senha from users where Email = ? and senha = ?";

			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getSenha());

			rs = stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public List<Record> getRecordsFromDatabase() {
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;
		List<Record> records = new ArrayList<>();

		try {
			String sql = "SELECT agendamento.id, atendentes.nome AS nome_atendente, diassemana.dia AS nome_dia_semana, horasdia.hora AS nome_hora_dia, tiposservico.servico AS nome_tipo_servico, agendamento.preco FROM agendamento JOIN atendentes ON agendamento.atendente_id = atendentes.id JOIN diassemana ON agendamento.dia_semana_id = diassemana.id JOIN horasdia ON agendamento.hora_dia_id = horasdia.id JOIN tiposservico ON agendamento.tipo_servico_id = tiposservico.id;";
			Statement statement = (Statement) con.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String atendente = rs.getString("nome_atendente");
				String diaSemana = rs.getString("nome_dia_semana");
				String horaDia = rs.getString("nome_hora_dia");
				String tipoServico = rs.getString("nome_tipo_servico");
				double preco = rs.getDouble("preco");

				Record record = new Record(id, atendente, diaSemana, horaDia, tipoServico, preco);
				records.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return records;
	}

	public void insertRecord(RecordId user) {

		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();

		try {

			String consultaPreco = "SELECT preco FROM tiposservico WHERE id = ?";
			double preco = 0.0;

			PreparedStatement statementConsulta = con.prepareStatement(consultaPreco);
			statementConsulta.setInt(1, user.getTipoServico());
			ResultSet resultSet = statementConsulta.executeQuery();

			if (resultSet.next()) {
				preco = resultSet.getDouble("preco");
			}

			String inserirAgendamento = "insert INTO agendamento (dia_semana_id, hora_dia_id, tipo_servico_id, preco, atendente_id ) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statementInsercao = con.prepareStatement(inserirAgendamento);
			statementInsercao.setInt(1, user.getDiaSemana());
			statementInsercao.setInt(2, user.getHoraDia());
			statementInsercao.setInt(3, user.getTipoServico());
			statementInsercao.setDouble(4, preco);
			statementInsercao.setInt(5, user.getAtendente());

			statementInsercao.executeUpdate();

			statementInsercao.close();
			statementConsulta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void updateRecord(RecordIdAlteration user) {
	    ConnectionBd bd = new ConnectionBd();
	    Connection con = bd.getCon();

	    try {
	        String consultaPreco = "SELECT preco FROM tiposservico WHERE id = ?";
	        double preco = 0.0;

	        PreparedStatement statementConsulta = con.prepareStatement(consultaPreco);
	        statementConsulta.setInt(1, user.getNovoServico());
	        ResultSet resultSet = statementConsulta.executeQuery();

	        if (resultSet.next()) {
	            preco = resultSet.getDouble("preco");
	        }

	        String atualizarAgendamento = "UPDATE agendamento SET dia_semana_id = ?, hora_dia_id = ?, tipo_servico_id = ?, preco = ?, atendente_id = ? WHERE id = ?";

	        PreparedStatement statementAtualizacao = con.prepareStatement(atualizarAgendamento);
	        statementAtualizacao.setInt(1, user.getNovoDia());
	        statementAtualizacao.setInt(2, user.getNovoHora());
	        statementAtualizacao.setInt(3, user.getNovoServico());
	        statementAtualizacao.setDouble(4, preco);
	        statementAtualizacao.setInt(5, user.getNovoAtendente());
	        statementAtualizacao.setInt(6, user.getId());

	        statementAtualizacao.executeUpdate();

	        statementAtualizacao.close();
	        statementConsulta.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	}

	public void deleteRecords(int[] ids) {
	    ConnectionBd bd = new ConnectionBd();
	    Connection con = bd.getCon();
	    try {
	        PreparedStatement statement = con.prepareStatement("DELETE FROM agendamento WHERE id = ?");
	        for (int id : ids) {
	            statement.setInt(1, id);
	            statement.addBatch();
	        }

	        int[] rowsDeleted = statement.executeBatch();
	        int totalRowsDeleted = 0;
	        for (int rows : rowsDeleted) {
	            totalRowsDeleted += rows;
	        }

	        if (totalRowsDeleted > 0) {
	            System.out.println("Registros excluídos com sucesso!");
	        } else {
	            System.out.println("Nenhum registro encontrado com os IDs fornecidos.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public List<Atendente> getAllAtendentes() {
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;
		List<Atendente> atendentes = new ArrayList<>();

		try {
			String sql = "SELECT * FROM atendentes";
			Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				String nome = rs.getString("nome");

				Atendente atendente = new Atendente(nome);
				atendentes.add(atendente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return atendentes;
	}

	public List<DiaSemana> getAllDiasSemana() {
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;
		List<DiaSemana> diasSemana = new ArrayList<>();

		try {
			String sql = "SELECT dia FROM diassemana";
			Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				String dia = rs.getString("dia");

				DiaSemana diaSemana = new DiaSemana(dia);
				diasSemana.add(diaSemana);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return diasSemana;
	}

	public List<HoraDia> getAllHorasDia() {
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;
		List<HoraDia> horasDia = new ArrayList<>();

		try {
			String sql = "SELECT * FROM horasdia";
			Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				String hora = rs.getString("hora");

				HoraDia horaDia = new HoraDia(hora);
				horasDia.add(horaDia);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return horasDia;
	}

	public List<TipoServico> getAllTiposServico() {
		ConnectionBd bd = new ConnectionBd();
		Connection con = bd.getCon();
		ResultSet rs = null;
		List<TipoServico> tiposServico = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tiposservico";
			Statement statement = con.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				String servico = rs.getString("servico");

				TipoServico tipoServico = new TipoServico(servico);
				tiposServico.add(tipoServico);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tiposServico;
	}

}
