package me.ndPrince.routeOptimization;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MappingServiceTest {

    @InjectMocks
    MappingService mappingService;

    @Test
    void testMappingService(){
        mappingService.calculateMatrix();
    }
}