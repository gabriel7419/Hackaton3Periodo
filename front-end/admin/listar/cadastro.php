<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/cadastro.css">
</head>

<body>
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

    <div class="login-box">
        <form action="configCadastro.php" method="POST" onsubmit="return validarFormulario()">
            <div class="mb-3 text-center">
                <img src="../imagens/logo.png" alt="Logo" class="logo">
            </div>
            <div class="mb-3 text-center">
                <legend>Cadastro Usuário</legend>
            </div>
            <div class="row mb-2">
                <div class="col">
                    <label for="nomeCompleto" class="form-label">Nome completo</label>
                    <input type="text" class="form-control" id="nomeCompleto" name="nomeCompleto" placeholder="Ex: Pedro Augusto" required>
                </div>
                <div class="col">
                    <label for="cpf" class="form-label">CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="000.000.000-00" oninput="formatarCPF(this);" required>
                </div>
                <div class="col">
                    <label for="cartaoSus" class="form-label">Cartão SUS</label>
                    <input type="text" class="form-control" id="cartaoSus" name="cartaoSus" placeholder="000 0000 0000 0000" oninput="formatarCartaoSus(this);" required>
                </div>
            </div>

            <div class="row mb-2">
                <div class="col">
                    <label for="cep" class="form-label">CEP</label>
                    <input type="text" class="form-control" id="cep" name="cep" placeholder="00000-000" oninput="formatarCEP(this); preencherEndereco();" required>
                </div>
                <div class="col">
                    <label for="Logradouro" class="form-label">Logradouro</label>
                    <input type="text" class="form-control" id="Logradouro" name="Logradouro" placeholder="ex: Av.Parana" required>
                </div>
                <div class="col">
                    <label for="dataNascimento" class="form-label">Data de Nascimento</label>
                    <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" required>
                </div>
            </div>

            <div class="divider"></div>
            <div class="row mb-2">
                <div class="col">
                    <label for="responsavel" class="form-label">Nome do Responsável</label>
                    <input type="text" class="form-control" id="responsavel" name="responsavel" placeholder="Nome do Responsável">
                </div>
                <div class="col">
                    <label for="cpfResponsavel" class="form-label">CPF do Responsável</label>
                    <input type="text" class="form-control" id="cpfResponsavel" name="cpfResponsavel" placeholder="000.000.000-00" oninput="formatarCPF(this);">
                </div>
                <div class="col">
                    <label for="emailResponsavel" class="form-label">Email do Responsável</label>
                    <input type="email" class="form-control" id="emailResponsavel" name="emailResponsavel" placeholder="email@gmail.com" required>
                </div>
            </div>

            <div class="row mb-2">
                <div class="col">
                    <label for="celular1" class="form-label">Celular 1</label>
                    <input type="tel" class="form-control" id="celular1" name="celular1" placeholder="(00) 00000-0000" maxlength="15" oninput="atualizarCelular(this);" required>
                </div>
                <div class="col">
                    <label for="celular2" class="form-label">Celular 2</label>
                    <input type="tel" class="form-control" id="celular2" name="celular2" placeholder="(00) 00000-0000" maxlength="15" oninput="atualizarCelular(this);" required>
                </div>
                <div class="col">
                    <label for="celular3" class="form-label">Celular 3</label>
                    <input type="tel" class="form-control" id="celular3" name="celular3" placeholder="(00) 00000-0000" maxlength="15" oninput="atualizarCelular(this);" required>
                </div>
            </div>

            <div class="divider"></div>
            <div class="row mb-2">
                <div class="col">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required>
                </div>
                <div class="col">
                    <label for="confirmarSenha" class="form-label">Confirmar Senha</label>
                    <input type="password" class="form-control" id="confirmarSenha" name="confirmarSenha" placeholder="Confirme a Senha" required>
                </div>
            </div>

            <div class="btn-container">
                <button type="button" class="btn btn-secondary btn-lg" onclick="goBack()">Voltar</button>
                <button type="submit" class="btn btn-primary btn-lg">Cadastrar-se</button>
            </div>
        </form>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }

        function formatarCPF(cpfInput) {
            let cpf = cpfInput.value.replace(/\D/g, ''); // Remove tudo o que não é dígito
            if (cpf.length > 11) {
                cpf = cpf.substring(0, 11);
            }
            cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2');
            cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2');
            cpf = cpf.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
            cpfInput.value = cpf;
        }

        function formatarCartaoSus(cartaoSusInput) {
            let cartaoSus = cartaoSusInput.value.replace(/\D/g, '');
            if (cartaoSus.length > 15) {
                cartaoSus = cartaoSus.substring(0, 15);
            }
            cartaoSus = cartaoSus.replace(/(\d{3})(\d)/, '$1 $2');
            cartaoSus = cartaoSus.replace(/(\d{4})(\d)/, '$1 $2');
            cartaoSus = cartaoSus.replace(/(\d{4})(\d)/, '$1 $2');
            cartaoSusInput.value = cartaoSus;
        }

        function formatarCEP(cepInput) {
            let cep = cepInput.value.replace(/\D/g, '');
            cep = cep.replace(/(\d{5})(\d)/, '$1-$2');
            cepInput.value = cep;
        }

        async function preencherEndereco() {
            const cep = document.getElementById('cep').value.replace(/\D/g, '');
            if (cep.length !== 8) {
                return;
            }
            const url = `https://viacep.com.br/ws/${cep}/json/`;
            try {
                const response = await fetch(url);
                const data = await response.json();
                if (data.erro) {
                    alert('CEP não encontrado.');
                    return;
                }
                document.getElementById('Logradouro').value = data.logradouro;
            } catch (error) {
                console.error('Erro ao buscar o CEP:', error);
                alert('Erro ao buscar o CEP. Por favor, tente novamente.');
            }
        }

        function atualizarCelular(input) {
            let numero = input.value.replace(/\D/g, '');
            if (numero.length > 15) {
                numero = numero.substring(0, 15);
            }
            numero = numero.replace(/^(\d{2})(\d)/g, '($1) $2');
            if (numero.length > 10) {
                numero = numero.replace(/(\d{5})(\d)/, '$1-$2');
            } else {
                numero = numero.replace(/(\d{4})(\d)/, '$1-$2');
            }
            input.value = numero;
        }

        function validarFormulario() {
            const senha = document.getElementById('senha').value;
            const confirmarSenha = document.getElementById('confirmarSenha').value;

            if (senha !== confirmarSenha) {
                alert('As senhas não coincidem. Por favor, verifique.');
                return false;
            }

            return true;
        }
        
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>
