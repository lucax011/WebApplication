<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nubarberia</title>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>
  <header class="header-page">
    <h1 class="header-title">
      <img class="" src="../img/Logo-circulo-barbearia-1024x1024-removebg-preview.png" alt="">
    </h1>
    <h1 class="header-title">Nubarberia</h1>
  </header>

  <div class="caixa-agendamento">
    <h1>Agende um horário com o cabelereiro</h1>
    <form action="" method="post">
      <div class="intro-content1">
        <label for="">Atendente:</label>
        <select id="selectOpcoesAtendente"></select>
        <label for="">Serviço:</label>
        <select id="selectOpcoesServico"></select>
        <label for="">Dia:</label>
        <select id="selectOpcoesDia"></select>
        <label for="">Horário:</label>
        <select id="selectOpcoesHora"></select>
      </div>
      <button class="button" type="submit" id="button">Agendar</button>
    </form>
    <div class="caixa-tabela">
      <table>
        <thead>
          <tr class="header-table" data-id="1">
            <th id="selecionar" class="coluna">Selecionar</th>
            <th id="atendente" class="coluna">Atendente</th>
            <th id="data" class="coluna">Data</th>
            <th id="hora" class="coluna">Hora</th>
            <th id="servico" class="coluna">Serviço</th>
            <th id="preco" class="coluna">Preço</th>
          </tr>
        </thead>
        <tbody id="tabela"></tbody>
        <tfoot>
          <tr>
            <td colspan="6" class="footer-table">
              <button class="buttonAlterar">Alterar agendamento</button>
              <button class="buttonExcluded">Excluir agendamento</button>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>

  <div id="modal" class="modal">
    <div class="modal-content">
      <span class="close">&times;</span>
      <h2>Alteração de Agendamento</h2>
      <form action="" method="post">
        <div class="intro-content1">
          <label for="">Atendente:</label>
          <select id="selectOpcoesAtendente1"></select>
          <label for="">Serviço:</label>
          <select id="selectOpcoesServico1"></select>
          <label for="">Dia:</label>
          <select id="selectOpcoesDia1"></select>
          <label for="">Horário:</label>
          <select id="selectOpcoesHora1"></select>
        </div>
        <button class="button" type="submit" id="buttonAlterarAgendamento">Alterar agendamento</button>
      </form>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="../js/script.js"></script>
</body>
</html>
