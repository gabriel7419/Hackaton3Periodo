<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal de Vacinação</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../admin/css/paginasemlogar.css">
</head>

<body>
    <header>
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-auto">
                    <div class="logo">
                        <img src="../admin/imagens/logoprincipal.png" alt="Logo do Site">
                    </div>
                </div>
                <div class="col-auto ms-auto">
                    <div class="login-options">
                        <button class="btn btn-link" onclick="toggleLoginPanel()">
                            <i class="fas fa-sign-in-alt"></i> Login
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container">
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
                    <img src="imagens/cor1.jpg" class="d-block w-100" alt="Imagem 1">
                </div>
                <div class="carousel-item">
                    <img src="imagens/cor2.png" class="d-block w-100" alt="Imagem 2">
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

    <!-- Painel de Login -->
    <div class="login-panel" id="loginPanel">
        <div class="login-panel-inner">
            <h2>Escolha o Login</h2>
            <button class="btn btn-primary" onclick="location.href='paginas/login.php'">
                <i class="fas fa-user"></i> Login Usuário
            </button>
            <button class="btn btn-primary mt-2" onclick="location.href='login_agente.php'">
                <i class="fas fa-user-tie"></i> Login Agente
            </button>
            <button class="btn btn-link mt-3" onclick="toggleLoginPanel()">
                Cancelar
            </button>
        </div>
    </div>

    <div class="container mt-4">
        <div class="row">
            <div class="col">
                <div class="options">
                    <a href="#" class="option">
                        <i class="fas fa-syringe"></i>
                        <span>Opções de Vacinação</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options">
                    <a href="#" class="option">
                        <i class="fas fa-id-card"></i>
                        <span>Carteirinha de Vacinação</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options">
                    <a href="#" class="option">
                        <i class="fas fa-calendar-check"></i>
                        <span>Agendar Vacinação</span>
                    </a>
                </div>
            </div>
            <div class="col">
                <div class="options">
                    <a href="#" class="option">
                        <i class="fas fa-history"></i>
                        <span>Histórico de Vacinação</span>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <script>
        function toggleLoginPanel() {
            var panel = document.getElementById("loginPanel");
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        }

        // Fecha o painel de login se o usuário clicar fora dele
        window.onclick = function(event) {
            if (!event.target.matches('.login-options') && !event.target.matches('.login-options *')) {
                var panel = document.getElementById("loginPanel");
                if (panel.style.display === "block") {
                    panel.style.display = "none";
                }
            }
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>