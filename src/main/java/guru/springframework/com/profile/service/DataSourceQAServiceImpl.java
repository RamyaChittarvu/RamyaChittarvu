package guru.springframework.com.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("QA")
@Service("ProfileService")
public class DataSourceQAServiceImpl implements DataSourceService {
    @Override
    public String printDataSource() {
        return "This is QA Environment";
    }
}
