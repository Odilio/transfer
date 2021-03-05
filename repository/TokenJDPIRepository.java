package br.com.b3.pip.gerenciarrecurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.b3.pip.gerenciarrecurso.model.TokenJDPI;

@Repository
public interface TokenJDPIRepository extends JpaRepository<TokenJDPI, Integer> {

	public TokenJDPI findByAccessToken(String acessToken);
	
	public TokenJDPI findByScope(String scope);


}
