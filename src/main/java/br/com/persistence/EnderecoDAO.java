package br.com.persistence;

import br.com.pojo.Endereco;

public interface EnderecoDAO {
	
	public boolean salvar(Endereco endereco);

	public boolean atualizar(Endereco endereco);

	public void excluir(Endereco endereco);

}
