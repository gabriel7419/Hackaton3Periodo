<?php 
session_start();

    require "./funcoes.php";
if(!isset($_SESSION['usuario'])){
    require "./paginas/paginasemlogar.php"; 
}else{
    if(isset($_GET["param"])){
        $page = explode("/", $_GET["param"]);
        
        $pasta = $page[0] ?? null;
        $arquivo = $page[1]?? null;
        $id = $page[2] ?? null;

        $page = "$pasta/$arquivo"; 
        

        if(file_exists("$page.php")){
            require "$page.php";
        }else{
            require "paginas/erro.php";
        }
    }
}

?>