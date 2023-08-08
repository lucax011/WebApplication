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
        <h1 class="header-title">Nubarberia</h1>
    </header>

    <div class="caixa-intro">
        <h1>Entre na sua conta</h1>
        <form>
            <div class="form-caixa">
                <label class="" for="e-mail">E-mail</label>
                <input type="text" name="e-mail" id="e-mail" autocomplete="on" required>
                <label class="" for="senha">Senha</label>
                <input class="" type="password" name="senha" id="senha" autocomplete="current-password" required>
            </div>
            <button class="button" type="submit" id="buttonLogin">Logar</button>
        </form>
    </div>

    <div class="error-container"></div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="../js/login.js"></script>
</body>
</html>
