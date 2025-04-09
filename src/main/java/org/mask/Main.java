package org.mask;

import net.sf.cglib.proxy.Enhancer;
import org.mask.annotations.CPF;
import org.mask.annotations.Masker;
import org.mask.core.MaskType;
import org.mask.core.proxy.MaskInterceptor;
import org.mask.core.proxy.MaskProxy;

public class Main {
    public static void main(String[] args) {
        Teste teste = new Teste("John Doe", "1234567890", "12015793410");
        Teste proxy = MaskProxy.create(teste);
        System.out.println("Name: " + proxy.getPhone());
        System.out.println("Cpf: " + proxy.getCpf());
    }

    public static class Teste {
        private String name;
        @Masker(type = MaskType.PHONE, mask = "(##) #####-####")
        private String phone;
        @CPF
        private String cpf;

        public Teste(String name, String phone, String cpf) {
            this.name = name;
            this.phone = phone;
            this.cpf = cpf;
        }
        public Teste () {
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getCpf() {
            return cpf;
        }
    }
}