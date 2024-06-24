<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal de Vacinação</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/paginalogado.css">
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

    <div class="container mt-4">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 5"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="5" aria-label="Slide 6"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="../imagens/cor1.jpg" class="d-block w-100" alt="Imagem 1">
                </div>
                <div class="carousel-item">
                    <img src="../imagens/cor2.jpg" class="d-block w-100" alt="Imagem 2">
                </div>
                <div class="carousel-item">
                    <img src="../imagens/cor3.png" class="d-block w-100" alt="Imagem 3">
                </div>
                <div class="carousel-item">
                    <img src="../imagens/cor4.png" class="d-block w-100" alt="Imagem 4">
                </div>
                <div class="carousel-item">
                    <img src="../imagens/cor5.png" class="d-block w-100" alt="Imagem 5">
                </div>
                <div class="carousel-item">
                    <img src="../imagens/cor6.png" class="d-block w-100" alt="Imagem 6">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col">
                <div class="options-panel">
                    <a href="../config/buscarVacinas" class="option">
                        <i class="fas fa-syringe"></i>
                        <span>Campanhas Ativas</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options-panel">
                    <a href="../listar/historico" class="option">
                        <i class="fas fa-history"></i>
                        <span>Histórico de Vacinação</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options-panel">
                    <a href="../listar/agendarVacina" class="option">
                        <i class="fas fa-user-md"></i>
                        <span>Agendar Vacinas</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options-panel">
                    <a href="../listar/meusagendamentos" class="option">
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
