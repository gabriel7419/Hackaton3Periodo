<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vacinas em Campanha</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/agendar_vacina.css">
</head>

<body>
    <header>
        <div class="logo">
            <img src="../imagens/logoprincipal.png" alt="Logo de uma injeção">
        </div>
        <div class="user-options">
            <button class="btn btn-user" onclick="toggleUserPanel()">
                <i class="fas fa-user"></i>
            </button>
            <div class="user-panel" id="userPanel">
                <a href="#">
                    <i class="fas fa-user-cog"></i> Atualizar Cadastro
                </a>
                <a href="#">
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
        <h1>Agendar Vacina</h1>

        <div class="vacinas-list">
            <div class="vacina">
                <h2>Vacina contra Influenza</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec odio et ipsum blandit faucibus. Nam auctor velit quis dolor suscipit, nec varius risus lobortis.</p>
                <button class="btn btn-primary">Agendar</button>
            </div>

            <div class="vacina">
                <h2>Vacina contra COVID-19</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec odio et ipsum blandit faucibus. Nam auctor velit quis dolor suscipit, nec varius risus lobortis.</p>
                <button class="btn btn-primary">Agendar</button>
            </div>
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