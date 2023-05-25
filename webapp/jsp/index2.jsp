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

	<div>

		<form method="post" action="http://localhost:8080/javaWebApplication/Register">

			<h1>Cadastre-se</h1>



			<div class="intro">
				
				<div class="intro-content">
					<label class="" for="name">Nome </label> <br /> <input
						class=" required" type="text" name="nome" id="nome" required>
				</div>

				<div class="intro-content">
					<label class="" for="suname">Sobrenome</label> <br /> <input
						class=" required" type="text" name="sobrenome" id="sobrenome"
						required>
				</div>

				<div class="intro-content">
					<label class="" for="E-mail">E-mail</label> <br /> <input class=""
						type="text" name="e-mail" id="e-mail" placeholder="" required>
				</div>
				<div class="intro-content">
					<label class="" for="">Senha</label> <br /> <input class=""
						type="password" name="senha" id="senha" required>
				</div>
		
				<input class="button" value="Registre-se"type="submit" id="button">
		</form>
				<form action="http://localhost:7867/javaWebApplication/jsp/index3.jsp">
				<input class="buttonNext" value="Proxima pagina" type="submit" id="button">
				</form>
			</div>
	</div>
</body>
</html>