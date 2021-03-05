package br.com.b3.pip.gerenciarrecurso.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.b3.pip.gerenciarrecurso.enums.ParametrosSQLEnum;

public abstract class AbstractSpecification<T> implements Specification<T> {
	private static final long serialVersionUID = 1L;
	protected SearchCriteria criteria;
	
	public AbstractSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	public AbstractSpecification() {}
	
	@Override
    public Predicate toPredicate
      (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
 
		if (criteria == null) {
			return null;
		}
		
		if (criteria.getOperation().equalsIgnoreCase(ParametrosSQLEnum.MAIOR.getTipo())) {
		    return builder.greaterThanOrEqualTo(
		    		root.get(criteria.getKey()), criteria.getValue().toString());
		} 
		else if (criteria.getOperation().equalsIgnoreCase(ParametrosSQLEnum.MENOR.getTipo())) {
		    return builder.lessThanOrEqualTo(
		    		root.get(criteria.getKey()), criteria.getValue().toString());
		}
		else if (criteria.getOperation().equals(ParametrosSQLEnum.BETWEEN.getTipo())) {
			return builder.between(
					root.get(criteria.getKey()), criteria.getDataUm(), criteria.getDataDois());
		}
		else if (criteria.getOperation().equalsIgnoreCase(ParametrosSQLEnum.IGUAL.getTipo())) {
		    if (root.get(criteria.getKey()).getJavaType() == String.class) {
		        return builder.like(
		        		root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		    } else {
		        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		    }
		}
		else if (criteria.getOperation().equalsIgnoreCase(ParametrosSQLEnum.SOMENTE_NULO.getTipo())) {
			return builder.isNull(
					root.get(criteria.getKey()));
		}
		
		return null;
    }
	
}
