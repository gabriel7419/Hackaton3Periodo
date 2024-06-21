<?php

$email = $_POST['email'];
$senha = $_POST['senha'];

$url = 'http://localhost:8000/idoso';
$ch = curl_init($url);

curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);

$dados = json_encode([
    'email' => $email,
    'senha' => $senha
]);

$headers = array(
    'Content-Type: application/json', // Set the Content-Type header to application/json
    'Content-Length: ' . strlen($dados) // Set the Content-Length header to the length of the JSON payload
);

curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);

$response = curl_exec($ch);
$data = json_decode($response, true);

//  var_dump($data);
// exit;
if ($data['message'] == "existe") {
    echo "<script>location.href='paginas/paginalogado.php'</script>";
} else {
    echo "<script>location.href='paginas/login.php'</script>";
}

?>