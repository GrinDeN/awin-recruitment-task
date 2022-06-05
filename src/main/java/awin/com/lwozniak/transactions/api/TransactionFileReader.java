package awin.com.lwozniak.transactions.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class TransactionFileReader implements TransactionReader {

    @Value("${input.filename}")
    public String dataFilename;

    @Override
    public List<TransactionDto> read() {
        InputTransactions inputTransactions;
        try (InputStream json = getClass().getClassLoader().getResourceAsStream(dataFilename)) {
            ObjectMapper objectMapper = registerObjectMapper();
            inputTransactions = objectMapper.readValue(json, InputTransactions.class);
        } catch (IOException e) {
            log.error("Error during reading file: {}", dataFilename);
            throw new RuntimeException("Cannot read input file, please check if it exists and is not broken");
        }
        return Optional.ofNullable(inputTransactions)
                .map(InputTransactions::getTransactions)
                .orElseGet(ArrayList::new);
    }

    private ObjectMapper registerObjectMapper() {
        return new ObjectMapper().findAndRegisterModules();
    }
}
