package guru.springframework.com.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Prod")
@Service("ProfileService")
public class DataSourceProdServiceImpl implements DataSourceService {
    @Override
    public String printDataSource() {
        return "This is Production Environment";
    }
}
