<?php 
session_start();
$vacinas = $_SESSION['vacina'];

?>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vacinas em Campanha</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/campanhas.css">
</head>

<body>
    <header>
        <div class="logo">
            <img src="../imagens/logoprincipal.png" alt="Logo do Site">
        </div>
         <div class="user-options">
            <button class="btn btn-user" onclick="toggleUserPanel()">
                <i class="fas fa-user"></i>
            </button>
            <div class="user-panel" id="userPanel">
                <a href="../logout.php">
                    <i class="fas fa-sign-out-alt"></i> Sair
                </a>
            </div>
        </div>
        <div vw class="enabled">
            <div vw-access-button class="active"></div>
            <div vw-plugin-wrapper>
                <div class="vw-plugin-top-wrapper"></div>
            </div>
        </div>
        <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
        <script>
            new window.VLibras.Widget('https://vlibras.gov.br/app');
        </script>
    </header>

    <main class="container mt-4">
        <h1>Vacinas em Campanha</h1>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Data de Início</th>
                        <th scope="col">Data de Término</th>
                        <th scope="col">Público Alvo</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach($vacinas as $info){
                        for ($i = 0; $i <= count($info); $i++) {
                    ?>  
                    <tr>
                        <td><?= $info[$i]['nome']?></td>
                        <td><?= $info[$i]['dataInicio']?></td>
                        <td><?= $info[$i]['dataTermino']?></td>
                        <td><?= $info[$i]['publicoAlvo']?></td>   
                    </tr>
                    <?php 
                        }}
                    ?>
                </tbody>
            </table>
        </div>

        <button class="btn btn-secondary mb-3" onclick="window.history.back()">
            <i class="fas fa-arrow-left"></i> Voltar
        </button>

    </main>

<script>
        function toggleUserPanel() {
            var panel = document.getElementById("userPanel");
            panel.classList.toggle("active");
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>