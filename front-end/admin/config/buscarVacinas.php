<?php 
session_start();

$url = 'http://localhost:8000/vacina';

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
curl_setopt($ch, CURLOPT_HTTPGET, true); // Define que a requisição será do tipo GET
$response = curl_exec($ch);
$data = json_decode($response,true);

// var_dump($data);
// exit;

$_SESSION['vacina'] = $data;

echo "<script>location.href='../listar/vacinas_em_campanha.php'</script>";