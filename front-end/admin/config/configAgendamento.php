<?php 
session_start();

    $data  = $_SESSION['datas'];
    var_dump($data );
    // exit;

$idPaciente = $data['user']['id'];
var_dump($idPaciente );
// exit;
$agente = $_POST['agente'];
$data = $_POST['data'];
$vacina = $_POST['vacina'];

$url = 'http://localhost:8000/agendamentos';
$ch = curl_init($url);

curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);

$dados = json_encode([
    'idoso_id' => $idPaciente,
    'dataVas' => $data, 
    'agentesaude_id' => $agente,
    'vacina_id' => $vacina
]);

//exit;
$headers = array(
    'Content-Type: application/json', 
    'Content-Length: ' . strlen($dados) 
);

curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, CURLOPT_POSTFIELDS, $dados);

$response = curl_exec($ch);
$resp = json_decode($response, true);

var_dump($resp);
exit;


if ($resp['message'] == "Agendamento criado com sucesso") {
    echo "chegou aqui";
     exit;
    echo "<script>location.href='../listar/agendarVacina'</script>";
} else {

    echo "<script>location.href='../listar/agendarVacina'</script>";
}

?>
