package guru.springframework.com.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile({"Dev","default"})
@Service("ProfileService")
public class DataSourceServiceImpl implements DataSourceService {
    @Override
    public String printDataSource() {
        return "This is Development Environment";
    }
}
