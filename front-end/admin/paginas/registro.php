<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="registro-container">
        <h2>Registro de Novo Usuário</h2>
        <form action="" method="post">
            <div class="input-group">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required>
            </div>
            <div class="input-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div>
            <div class="input-group">
                <button type="submit">Registrar</button>
            </div>
        </form>
        <div class="options">
            <a href="../paginas/login.php">Voltar para o Login</a>
        </div>
    </div>
</body>
</html>

<?php
// Aqui você pode adicionar o código PHP para processar o registro do usuário
?>
