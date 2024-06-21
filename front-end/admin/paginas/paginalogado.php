<?php
    session_start();
    $data  = $_SESSION['datas'];
    // var_dump($data )
?>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal de Vacinação</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="../css/paginalogado.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <header>
        <div class="logo">
            <img src="../imagens/logoprincipal.png" alt="Logo do Site">
        </div>
        <div class="user-options" onclick="toggleUserPanel()">
            <span>Bem-vindo,<?= $data["rows"][0]["nome"] ?? ""?></span>
            <i class="fas fa-user"></i>
            <div class="user-panel" id="userPanel">
                <a href="#">
                    <i class="fas fa-user-edit"></i> Atualizar Cadastro
                </a>
                <a href="#">
                    <i class="fas fa-sign-out-alt"></i> Sair
                </a>
            </div>
        </div>
    </header>

    <div class="container">
        <div class="cortana">
            <p>Bem-vindo à plataforma de vacinação! Escolha uma das opções abaixo para continuar.</p>
        </div>
        <div class="options">
            <a href="#" class="option">
                <i class="fas fa-syringe"></i>
                <span>Opções de Vacinação</span>
            </a>
            <a href="#" class="option">
                <i class="fas fa-id-card"></i>
                <span>Carteirinha de Vacinação</span>
            </a>
            <a href="#" class="option">
                <i class="fas fa-calendar-check"></i>
                <span>Agendar Vacinação</span>
            </a>
            <a href="#" class="option">
                <i class="fas fa-history"></i>
                <span>Histórico de Vacinação</span>
            </a>
        </div>
    </div>

    <script>
        function toggleUserPanel() {
            var panel = document.getElementById("userPanel");
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        }

        // Fecha o painel do usuário se o usuário clicar fora dele
        window.onclick = function(event) {
            if (!event.target.matches('.user-options') && !event.target.matches('.user-options *')) {
                var panel = document.getElementById("userPanel");
                if (panel.style.display === "block") {
                    panel.style.display = "none";
                }
            }
        }
    </script>
</body>
</html>