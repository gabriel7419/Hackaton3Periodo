<?php
session_start();
$sus = $_POST['cartao_sus'];
$senha = $_POST['senha'];

$url = 'http://localhost:8000/idoso';
$ch = curl_init($url);

curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);

$dados = json_encode([
    'cartaosus' => $sus,
    'senha' => $senha
]);

$headers = array(
    'Content-Type: application/json', 
    'Content-Length: ' . strlen($dados) 
);

curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);

$response = curl_exec($ch);
$data = json_decode($response, true);

if ($data['message'] == "Email e senha são obrigatórios") {
    echo "<script>location.href='../paginas/login.php'</script>";
} 
if ($data['message'] == "Usuário não encontrado") {
    echo "<script>location.href='../paginas/login.php'</script>";
} else {
    $_SESSION['datas'] = $data;
//   var_dump($_SESSION['datas']);
//  exit;
    echo "<script>location.href='../paginas/paginalogado.php'</script>";
}

?>