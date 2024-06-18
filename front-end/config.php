<?php

//$servidor = "localhost";
//$usuario  = "root";
//$senha    = "";
//$banco    = "vacinacao";

//try {
    //$pdo = new PDO("mysql:host={$servidor};dbname={$banco};port=3306;charset=utf8;", $usuario, $senha);
    //$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
//} catch (Exception $e) {
    //echo "<p>Erro ao tentar conectar</p>";
    //echo $e->getMessage();
    //exit;
//}

//if ($_SERVER["REQUEST_METHOD"] == "POST") {
    //if (!isset($_POST['email']) || !isset($_POST['senha'])) {
       // echo "<p>Email ou senha não fornecidos.</p>";
       // exit;
   // }

    //$email = $_POST['email'];
    //$senha = $_POST['senha'];

    // Debug: Exibir os valores de email e senha
   // echo "Email: " . htmlspecialchars($email) . "<br>";
   // echo "Senha: " . htmlspecialchars($senha) . "<br>";

   // $sql = "SELECT * FROM idoso WHERE email = :email";
   // $stmt = $pdo->prepare($sql);
   // $stmt->bindParam(':email', $email);

  //  try {
    //    $stmt->execute();
    //    $usuario = $stmt->fetch(PDO::FETCH_ASSOC);
//
       // if ($usuario && password_verify($senha, $usuario['senha'])) {
         //   $_SESSION['usuario_id'] = $usuario['id'];
        //    $_SESSION['usuario_nome'] = $usuario['nome'];
        //    header("Location: dashboard.php");
        //    exit;
       // } else {
          //  echo "<p>Email ou senha incorretos.</p>";
       // }
   // } catch (Exception $e) {
      //  echo "<p>Erro ao executar a consulta</p>";
      //  echo $e->getMessage();
      //  exit;
  //  }
//}
?>
