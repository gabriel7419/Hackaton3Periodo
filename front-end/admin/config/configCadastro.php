<?php
session_start();
include 'db_connection.php';  // Certifique-se de que o arquivo db_connection.php existe e está correto

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Captura os dados do formulário
    $nomeCompleto = $_POST['nomeCompleto'];
    $cpf = $_POST['cpf'];
    $cartaoSus = $_POST['cartaoSus'];
    $cep = $_POST['cep'];
    $logradouro = $_POST['Logradouro'];
    $dataNascimento = $_POST['dataNascimento'];
    $responsavel = $_POST['responsavel'];
    $cpfResponsavel = $_POST['cpfResponsavel'];
    $emailResponsavel = $_POST['emailResponsavel'];
    $celular1 = $_POST['celular1'];
    $celular2 = $_POST['celular2'];
    $celular3 = $_POST['celular3'];
    $senha = password_hash($_POST['senha'], PASSWORD_DEFAULT);  // Senha deve ser armazenada de forma segura

    try {
        // Conexão com o banco de dados
        $pdo = new PDO('mysql:host=localhost;dbname=vacinacao', 'usuario', 'senha');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        // Prepara a consulta SQL para inserção de dados
        $sql = "INSERT INTO idoso (nome_completo, cpf, cartao_sus, cep, logradouro, data_nascimento, responsavel, cpf_responsavel, email_responsavel, celular1, celular2, celular3, senha) 
                VALUES (:nomeCompleto, :cpf, :cartaoSus, :cep, :logradouro, :dataNascimento, :responsavel, :cpfResponsavel, :emailResponsavel, :celular1, :celular2, :celular3, :senha)";
        $consulta = $pdo->prepare($sql);
        $consulta->bindParam(":nomeCompleto", $nomeCompleto);
        $consulta->bindParam(":cpf", $cpf);
        $consulta->bindParam(":cartaoSus", $cartaoSus);
        $consulta->bindParam(":cep", $cep);
        $consulta->bindParam(":logradouro", $logradouro);
        $consulta->bindParam(":dataNascimento", $dataNascimento);
        $consulta->bindParam(":responsavel", $responsavel);
        $consulta->bindParam(":cpfResponsavel", $cpfResponsavel);
        $consulta->bindParam(":emailResponsavel", $emailResponsavel);
        $consulta->bindParam(":celular1", $celular1);
        $consulta->bindParam(":celular2", $celular2);
        $consulta->bindParam(":celular3", $celular3);
        $consulta->bindParam(":senha", $senha);
        $consulta->execute();

        // Define mensagem de sucesso
        $_SESSION['mensagem'] = "Cadastro realizado com sucesso!";
    } catch (PDOException $e) {
        // Em caso de erro, define mensagem de erro
        $_SESSION['mensagem'] = "Erro ao cadastrar: " . $e->getMessage();
    }

    // Redireciona para a página adequada após o cadastro
    header("Location: listar/cadastro");
    exit();
} else {
    // Se o método de requisição não for POST, redireciona para a página de cadastro
    header("Location: listar/cadastro");
    exit();
}
?>
