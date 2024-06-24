<?php
session_start();

// Configurar a URL da API
$url = 'http://localhost:8000/agenteSaude';

// Inicializar o cURL
$ch = curl_init($url);

// Configurar cURL para retornar a resposta em vez de imprimir
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPGET, true); // Define que a requisição será do tipo GET

// Executar a requisição cURL
$response = curl_exec($ch);
curl_close($ch);

// Decodificar a resposta JSON
$agente = json_decode($response, true);

// Verificar se a resposta é válida
if (json_last_error() !== JSON_ERROR_NONE) {
    die('Erro ao decodificar a resposta JSON: ' . json_last_error_msg());
}

// Verificar se os dados de sessão estão definidos
if (!isset($_SESSION['datas']) || !isset($_SESSION['vacina'])) {
    die('Dados de sessão não encontrados.');
}

// Atribuir os dados de sessão a variáveis
$data = $_SESSION['datas'];
$vacina = $_SESSION['vacina'];

// Atribuir o array de vacinas a uma variável
$vacinas = $vacina;
?>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agendamento de Vacinação</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="../css/agendar_vacina.css">
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
    <div class="container">
        <h2 class="mb-4">Agendamento de Vacinação</h2>
        <form id="agendamentoForm" action="../config/configAgendamento.php" method="post">
            <div class="form-group">
                <label for="agente">Agente:</label>
                <select id="agente" name="agente" class="form-control" required>
                    <option value="">Selecione...</option>
                    <?php 
                    foreach ($agente as $a) {
                        echo '<option value="' . $a['agente'] . '">' . $a['agente'] . '</option>';
                    }
                    ?>
                </select>
            </div>
            <div class="form-group">
                <label for="data">Escolha a Data:</label>
                <input type="date" id="data" name="data" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="vacina">Escolha a Vacina:</label>
                <select id="vacina" name="vacina" class="form-control" required>
                    <option value="">Selecione...</option>
                    <?php 
                    
                    
                    foreach($vacinas as $v){
                    ?>
                    <option value="Vacina A"><?=$v[1]["nome"]?></option>
                    <?php 
                    }
                    ?>
                </select>
            </div>
            <button class="btn btn-secondary" onclick="window.history.back()">
                <i class="fas fa-arrow-left"></i> Voltar
            </button>
            <button type="submit" class="btn btn-primary">Agendar</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>