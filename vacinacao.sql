-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24/06/2024 às 02:57
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `vacinacao`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `agendamentos`
--

CREATE TABLE `agendamentos` (
  `id` int(11) NOT NULL,
  `idoso_id` int(11) NOT NULL,
  `agentesaude_id` int(11) NOT NULL,
  `dataVas` varchar(10) NOT NULL,
  `vacina_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agendamentos`
--

INSERT INTO `agendamentos` (`id`, `idoso_id`, `agentesaude_id`, `dataVas`, `vacina_id`) VALUES
(1, 1, 1, '20240701', 1),
(2, 1, 1, '20240701', 1),
(3, 1, 1, '20240701', 1),
(4, 1, 1, '20240701', 1),
(5, 1, 2, '20240701', 1),
(7, 1, 2, '20240701', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `agentesaude`
--

CREATE TABLE `agentesaude` (
  `id` int(11) NOT NULL,
  `agente` varchar(85) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agentesaude`
--

INSERT INTO `agentesaude` (`id`, `agente`, `email`, `senha`) VALUES
(1, 'Paiva', '', ''),
(2, 'RAINALDO', 'rodrigoalcantara281@gmail.com', 'senha123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `historico`
--

CREATE TABLE `historico` (
  `id` int(11) NOT NULL,
  `idoso_id` int(11) DEFAULT NULL,
  `agenda_id` int(11) DEFAULT NULL,
  `vacina_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `horarios_disponiveis`
--

CREATE TABLE `horarios_disponiveis` (
  `id` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `disponivel` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `idoso`
--

CREATE TABLE `idoso` (
  `id` int(11) NOT NULL,
  `nome` varchar(85) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cartaosus` varchar(15) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `logradouro` varchar(120) DEFAULT NULL,
  `dataNasci` date NOT NULL,
  `nomeResponsavel` varchar(300) NOT NULL,
  `cpfResponsavel` varchar(11) NOT NULL,
  `emailResponsavel` varchar(160) NOT NULL,
  `celular1` varchar(12) NOT NULL,
  `celular2` varchar(12) NOT NULL,
  `celular3` varchar(12) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `idoso`
--

INSERT INTO `idoso` (`id`, `nome`, `cpf`, `cartaosus`, `cep`, `logradouro`, `dataNasci`, `nomeResponsavel`, `cpfResponsavel`, `emailResponsavel`, `celular1`, `celular2`, `celular3`, `senha`) VALUES
(1, 'rodrigo', 'dada', '000000000000000', 'daw', 'dawd', '2024-06-11', 'dawd', '', 'rodrigoalcantara281@gmail.com', 'awda', 'adwd', 'awd', 'senha123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `vacina`
--

CREATE TABLE `vacina` (
  `id` int(11) NOT NULL,
  `nome` varchar(85) DEFAULT NULL,
  `dataInicio` date NOT NULL,
  `dataTermino` date NOT NULL,
  `publicoAlvo` varchar(100) NOT NULL,
  `dose` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vacina`
--

INSERT INTO `vacina` (`id`, `nome`, `dataInicio`, `dataTermino`, `publicoAlvo`, `dose`) VALUES
(1, 'Gripe', '2024-06-03', '2024-06-26', 'menor de 18 anos', ''),
(2, 'Covid ', '2024-06-02', '2024-06-29', 'para todas das idades', ''),
(3, 'ddddd', '2024-06-11', '2024-06-07', 'dddddd', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idoso_id` (`idoso_id`),
  ADD KEY `agentesaude_id` (`agentesaude_id`),
  ADD KEY `vacina_id` (`vacina_id`);

--
-- Índices de tabela `agentesaude`
--
ALTER TABLE `agentesaude`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idoso_id` (`idoso_id`),
  ADD KEY `agenda_id` (`agenda_id`),
  ADD KEY `vacina_id` (`vacina_id`);

--
-- Índices de tabela `horarios_disponiveis`
--
ALTER TABLE `horarios_disponiveis`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `idoso`
--
ALTER TABLE `idoso`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `vacina`
--
ALTER TABLE `vacina`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamentos`
--
ALTER TABLE `agendamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `agentesaude`
--
ALTER TABLE `agentesaude`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `historico`
--
ALTER TABLE `historico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `horarios_disponiveis`
--
ALTER TABLE `horarios_disponiveis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `idoso`
--
ALTER TABLE `idoso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `vacina`
--
ALTER TABLE `vacina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `agendamentos`
--
ALTER TABLE `agendamentos`
  ADD CONSTRAINT `agendamentos_ibfk_1` FOREIGN KEY (`idoso_id`) REFERENCES `idoso` (`id`),
  ADD CONSTRAINT `agendamentos_ibfk_2` FOREIGN KEY (`agentesaude_id`) REFERENCES `agentesaude` (`id`),
  ADD CONSTRAINT `agendamentos_ibfk_3` FOREIGN KEY (`vacina_id`) REFERENCES `vacina` (`id`);

--
-- Restrições para tabelas `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `historico_ibfk_1` FOREIGN KEY (`idoso_id`) REFERENCES `idoso` (`id`),
  ADD CONSTRAINT `historico_ibfk_2` FOREIGN KEY (`agenda_id`) REFERENCES `agendamentos` (`id`),
  ADD CONSTRAINT `historico_ibfk_3` FOREIGN KEY (`vacina_id`) REFERENCES `vacina` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
