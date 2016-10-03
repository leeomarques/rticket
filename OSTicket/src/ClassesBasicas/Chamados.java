package ClassesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CHAMADOS")
public class Chamados {
    
    @Id
    @GeneratedValue
    @Column(name="ID", length=6, nullable=false, unique=true)
    int id;
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    Usuario usuarios;
}
