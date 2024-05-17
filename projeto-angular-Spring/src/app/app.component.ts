import { Component } from '@angular/core';
import { NgForm } from '@angular/forms'; 
import { RegistroUsuarioService } from './services/registro-usuario.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userData: any = { nome: '', email: '', senha: '', confirmarSenha: '' }; 
  registroSucesso: boolean | null = null; 
  botaoHabilitado: boolean = false;

  constructor(private registroUsuarioService: RegistroUsuarioService) {
    console.log('AppComponent inicializado.');
    
  } 

  validarFormulario(registrationForm: NgForm) {
    const { nome, email, senha, confirmarSenha } = registrationForm.controls;
    this.botaoHabilitado = nome.valid && email.valid && senha.valid && confirmarSenha.valid;
    console.log('Botão habilitado ao iniciar:', this.botaoHabilitado);
  }

  onSubmit(registrationForm: NgForm) {
    if (this.userData.senha !== this.userData.confirmarSenha) {
      registrationForm.controls['confirmarSenha'].setErrors({ 'passwordMismatch': true });
      return; 
    }

    this.registroUsuarioService.registrarUsuario(this.userData)
      .subscribe(
        (response) => {
          console.log('Usuário registrado com sucesso:', response);
          this.registroSucesso = true; 
          registrationForm.resetForm();
          setTimeout(() => {
            this.registroSucesso = null;
          }, 3000); 
        },
        (error) => {
          console.error('Erro ao registrar usuário:', error);
          this.registroSucesso = false; 
        }
      );
  }
}
