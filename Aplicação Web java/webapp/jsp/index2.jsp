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
			<img class=""
				src="../img/Logo-circulo-barbearia-1024x1024-removebg-preview.png"
				alt="">
		</h1>
		<h1 class="header-title">Nubarbearia</h1>
	</header>
	<div class="caixa-intro">
		<h1>Cadastre-se</h1>
		<div class="intro-content">
			<form method="post"
				action="http://localhost:8080/javaWebapplication/RegisterUser">
				<div class="form-caixa">
					<label class="" for="name">Nome </label> <input type="text"
						name="nome" id="nome"> <label class="" for="suname">Sobrenome</label>
					<input type="text" name="sobrenome" id="sobrenome" required>
					<label class="" for="E-mail">E-mail</label> <input type="text"
						name="e-mail" id="e-mail" placeholder="" required> <label
						class="" for="">Senha</label> <input type="password" name="senha"
						id="senha" required>
				</div>
				<button class="button" value="Registre-se" type="submit" id="button">Registre-se</button>
			</form>
		</div>
	</div>

</body>
</html>