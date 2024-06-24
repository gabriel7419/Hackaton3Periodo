<?php
    session_start();
    $data  = $_SESSION['datas'];
    var_dump($data );
    // exit;
?>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Histórico de Vacinação</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/historico.css">
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
        <h1>Histórico de Vacinação</h1>
        <?php
        $historico = array(
            array("data" => "2023-01-15", "vacina" => "COVID-19", "dose" => "1ª Dose"),
            array("data" => "2023-02-28", "vacina" => "H1N1", "dose" => "2ª Dose"),
            array("data" => "2023-04-10", "vacina" => "Gripe", "dose" => "Única"),
            array("data" => "2023-06-22", "vacina" => "Tétano", "dose" => "Reforço"),
        );
        ?>

        <!-- Tabela para exibir o histórico -->
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vacina</th>
                        <th>Dose</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($historico as $registro) : ?>
                        <tr>
                            <td><?php echo $registro['data']; ?></td>
                            <td><?php echo $registro['vacina']; ?></td>
                            <td><?php echo $registro['dose']; ?></td>
                        </tr>
                    <?php endforeach; ?>
                </tbody>
            </table>
        </div>
        <!-- Botão de Voltar -->
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