package com.ensi.ilsi.myclinic.ConsultationService.domain;
import com.ensi.ilsi.myclinic.commons.domain.AbstractEntity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "observation", nullable = false)
    private String observation;

        
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    
    @NotNull
    @Column(name = "treatment", nullable = false)
    private String treatment;
    
    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(unique = true)
    private Consultation consultation;
    
    public Order() {
        // JPA
    }
   
    public Order(@NotNull String title, @NotNull String observation, @NotNull String treatment,
			@NotNull LocalDateTime date, Consultation consultation) {
		super();
		this.title = title;
		this.observation = observation;
		this.treatment = treatment;
		this.date = date;
                this.consultation = consultation;
	}

}