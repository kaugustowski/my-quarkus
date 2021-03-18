package pl.wizyg.quarkus.stock;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StockRepository implements PanacheRepository<Stock> {

    public Optional<Stock> findByStockName(String name){
        return find("name", name).firstResultOptional();
    }

    public List<Stock> findAllStocks(){
        return findAll().list();
    }

    public Optional<Stock> findByStockId(long id){
        return find("id", id).firstResultOptional();
    }

    public void createStock(Stock stock){
        persist(stock);
    }
}
