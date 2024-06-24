<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meus Agendamentos</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/meus_agendamentos.css"> <!-- Estilo customizado -->
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
    </header>

    <main class="container mt-4">
        <h1>Meus Agendamentos</h1>

        <div class="agendamentos-list">
            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">Consulta de Cardiologia</h5>
                    <p class="card-text"><strong>Data:</strong> 01/07/2024</p>
                    <p class="card-text"><strong>Hora:</strong> 15:00</p>
                    <p class="card-text"><strong>Médico:</strong> Dr. João Silva</p>
                    <a href="#" class="btn btn-danger">Cancelar</a>
                </div>
            </div>

            <div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">Exame de Laboratório</h5>
                    <p class="card-text"><strong>Data:</strong> 05/07/2024</p>
                    <p class="card-text"><strong>Hora:</strong> 09:30</p>
                    <p class="card-text"><strong>Local:</strong> Laboratório ABC</p>
                    <a href="#" class="btn btn-danger">Cancelar</a>
                </div>
            </div>

            <!-- Adicione mais agendamentos conforme necessário -->
        </div>

        <button class="btn btn-secondary" onclick="window.history.back()">
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
