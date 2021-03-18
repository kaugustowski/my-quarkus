package pl.wizyg.quarkus.stock;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stocks")
public class Stock extends PanacheEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private int count;
    @Column(name = "buy_price")
    private BigDecimal buyPrice;
    @Column(name = "transaction_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate transactionDate;


}
