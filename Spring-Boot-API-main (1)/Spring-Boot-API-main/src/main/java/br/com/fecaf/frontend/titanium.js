// app.js

// Função para confirmar a saída do usuário
function confirmarSaida(event) {
  event.preventDefault();
  const sair = confirm("Deseja realmente sair?");
  if (sair) {
    window.location.href = 'titanium.html'; // ajuste o caminho se necessário
  }
}

// Função para detectar a página atual pelo nome do arquivo
function getPaginaAtual() {
  const path = window.location.pathname;
  return path.substring(path.lastIndexOf('/') + 1);
}

// Código que roda quando o DOM estiver carregado
document.addEventListener('DOMContentLoaded', () => {
  // Seleciona o link "Sair" pelo id para maior clareza e manutenção
  const sairLink = document.getElementById('link-sair');
  if (sairLink) {
    sairLink.addEventListener('click', confirmarSaida);
  }

  // Detecta a página atual para executar código específico
  const pagina = getPaginaAtual();

  if (pagina === 'titanium.html' || pagina === 'index.html') {
    configurarLoginCadastro();
  } else if (pagina === 'cartoes.html') {
    carregarCartoes();
  } else if (pagina === 'emprestimo.html') {
    configurarSimulacaoEmprestimo();
  } else if (pagina === 'debito-automatico.html') {
    configurarDebitoAutomatico();
  }
  // Adicione outros else if para outras páginas conforme necessário
});

// Função para configurar login e cadastro
function configurarLoginCadastro() {
  const cpfInput = document.getElementById('cpf-cadastro');
  if (cpfInput) {
    cpfInput.addEventListener('input', function (e) {
      let value = e.target.value.replace(/\D/g, '').slice(0, 11);
      let formatted = '';

      if (value.length > 0) formatted = value.slice(0, 3);
      if (value.length >= 4) formatted += '.' + value.slice(3, 6);
      if (value.length >= 7) formatted += '.' + value.slice(6, 9);
      if (value.length >= 10) formatted += '-' + value.slice(9, 11);

      e.target.value = formatted;
    });
  }

  const loginForm = document.getElementById('loginForm');
  if (loginForm) {
    loginForm.addEventListener('submit', function(e) {
      e.preventDefault();

      const cpf = this.cpf.value.trim();
      const password = this.password.value.trim();

      if(cpf && password) {
        localStorage.setItem('userCpf', cpf);
        window.location.href = 'home.html';
      } else {
        alert('Por favor, preencha os campos necessários.');
      }
    });
  }

  const signupForm = document.getElementById('signupForm');
  if (signupForm) {
    signupForm.addEventListener('submit', function(e) {
      e.preventDefault();

      const cpf = this.cpf.value.trim();
      const email = this.email.value.trim();
      const password = this.password.value.trim();

      if (!cpf || !email || !password) {
        alert('Por favor, preencha todos os campos.');
        return;
      }

      const user = { cpf, email, password };
      localStorage.setItem('user', JSON.stringify(user));
      localStorage.setItem('userEmail', email);

      alert('Cadastro realizado com sucesso! Redirecionando para a home...');

      window.location.href = 'home.html';
    });
  }
}

// Função exemplo para carregar cartões (a ser implementada)
function carregarCartoes() {
  console.log('Carregando dados da página Cartões...');
  // Aqui você pode fazer fetch para o back-end e atualizar o DOM
}

// Função exemplo para configurar simulação de empréstimo (ainda não foi implementada)
function configurarSimulacaoEmprestimo() {
  console.log('Configurando simulação de empréstimo...');
  // Código para configurar o formulário e lógica da simulação
}

// Função para configurar a página de débito automático
function configurarDebitoAutomatico() {
  console.log('Configurando débito automático...');
  // Aqui você pode adicionar a lógica para gerenciar débito automático,
  // como abrir um modal, fazer fetch para o back-end, etc.
}
