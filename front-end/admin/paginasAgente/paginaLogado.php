<?php 
    session_start();
    $data  = $_SESSION['datas'];
?>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal de Vacinação</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/paginalogado2.css">
</head>

<body>
    <header>
        <div class="logo">
            <img src="../imagens/logoprincipal.png" alt="Logo do Site">
        </div>
        <div class="user-options">
            <button class="btn btn-user" onclick="toggleUserPanel()">
                <p><?= $data["user"]["agente"]?></p>
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

    <div class="container options">
        <div class="options-panel">
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <a href="../listar/vacinas_em_campanha.php" class="option">
                        <i class="fas fa-syringe"></i> <!-- Ícone de injeção -->
                        <span>Campanhas Ativas</span>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="../listar/historico.php" class="option">
                        <i class="fas fa-history"></i>
                        <span>Histórico de Vacinação</span>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="../listar/meusagendamentos.php" class="option">
                        <i class="fas fa-user-nurse"></i>
                        <span>Meus Agendamentos</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script>
        function toggleUserPanel() {
            var panel = document.getElementById("userPanel");
            panel.classList.toggle("active");
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
