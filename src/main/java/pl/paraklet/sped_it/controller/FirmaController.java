package pl.paraklet.sped_it.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.paraklet.sped_it.model.Firma;
import pl.paraklet.sped_it.service.FirmaService;

import java.util.List;

@NoArgsConstructor
@RestController
//@RequestMapping("/firma")
public class FirmaController {

    @Autowired
    private FirmaService firmaService;

    public FirmaController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    @PostMapping("/firma")
    public String registerFirma(@RequestBody Firma firma) {
        firmaService.registerFirma(firma);
        return "Firma registered successfully!";
    }
}