import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\git\\Prova-PremierSoft\\Prova PremierSoft\\src\\Academy_Candidates.csv";
        List<Candidatos> lista = new ArrayList<Candidatos>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                String[] vetor = line.split(";");
                String nome = vetor[0];
                Integer idade = Integer.parseInt(vetor[1].split(" ", 2)[0]);
                String vaga = vetor[2];
                String estado = vetor[3];
                Candidatos candidato = new Candidatos(nome, idade, vaga, estado);
                lista.add(candidato);
                line = br.readLine();
            }
//            System.out.println("Candidatos: ");
//            for(Candidatos candidato : lista){
//                System.out.println(candidato);
//            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
//        WEB,QA,MOBILE
        caculaPorcentagem(lista);
        calculaIdadeMedia(lista);
        findOldAge(lista);
        findYoungerAge(lista);
        somaIdades(lista);
        mostrarEstadosDistintos(lista);
        gerarCandidatosOrdenados(lista);
        findInstrutorQA(lista);
        findInstrutorMobile(lista);

    }

        public static void caculaPorcentagem(List<Candidatos> candidatos){
            Map<String,Long> countByVaga = (Map<String, Long>) candidatos.stream()
                    .collect(Collectors.groupingBy(Candidatos::getVaga, Collectors.counting()));
            System.out.println("Porcentagem de candidatos por vaga:");
            countByVaga.forEach((vaga,count)->{
                Double porcentagem = (double) count / candidatos.size()*100;
                System.out.printf("%s: %.2f%%\n", vaga, porcentagem);
            });
        }

        public static void calculaIdadeMedia(List<Candidatos> candidatos){
        int idadeMediaQa = 0;
        int countQa = 0;
        int idadeMediaWeb = 0;
        int countWeb = 0;
        int idadeMediaMobile = 0;
        int countMobile = 0;
            for (Candidatos candidato : candidatos) {
                switch (candidato.getVaga()){
                    case "QA":
                        idadeMediaQa += candidato.getIdade();
                        ++countQa;
                        break;
                    case "Web":
                        idadeMediaWeb += candidato.getIdade();
                        ++countWeb;
                        break;
                    case "Mobile":
                        idadeMediaMobile += candidato.getIdade();
                        ++countMobile;
                        break;
                }
            }
            System.out.println("Idade media dos candidatos Qa:" + idadeMediaQa/countQa);
            System.out.println("Idade media dos candidatos Web:" + idadeMediaWeb/countWeb);
            System.out.println("Idade media dos candidatos Mobile:" + idadeMediaMobile/countMobile);
        }

        public static void findOldAge(List<Candidatos> candidatos){
            Candidatos candidatoVelhoQa = null;
            Candidatos candidatoVelhoWeb = null;
            Candidatos candidatoVelhoMobile = null;
            for (Candidatos candidato : candidatos) {
                switch (candidato.getVaga()){
                    case "QA":
                        if (candidatoVelhoQa == null) {
                            candidatoVelhoQa = candidato;
                        }
                        if (candidato.getIdade()>=candidatoVelhoQa.getIdade()){
                            candidatoVelhoQa = candidato;
                        }
                        break;
                    case "Web":
                        if (candidatoVelhoWeb == null) {
                            candidatoVelhoWeb = candidato;
                        }
                        if (candidato.getIdade()>=candidatoVelhoWeb.getIdade()){
                            candidatoVelhoWeb = candidato;
                        }
                        break;
                    case "Mobile":
                        if (candidatoVelhoMobile == null) {
                            candidatoVelhoMobile = candidato;
                        }
                        if (candidato.getIdade()>=candidatoVelhoMobile.getIdade()){
                            candidatoVelhoMobile = candidato;
                        }
                        break;
                }
            }
            System.out.println("Idade do Candidato mais velho Qa:" + candidatoVelhoQa.getIdade());
            System.out.println("Idade do Candidato mais velho Web:" + candidatoVelhoWeb.getIdade());
            System.out.println("Idade do Candidato mais velho Mobile:" + candidatoVelhoMobile.getIdade());
        }

        public static void findYoungerAge(List<Candidatos> candidatos){
            Candidatos candidatoNovoQa = null;
            Candidatos candidatoNovoWeb = null;
            Candidatos candidatoNovoMobile = null;
            for (Candidatos candidato : candidatos) {
                switch (candidato.getVaga()){
                    case "QA":
                        if (candidatoNovoQa == null) {
                            candidatoNovoQa = candidato;
                        }
                        if (candidato.getIdade()<=candidatoNovoQa.getIdade()){
                            candidatoNovoQa = candidato;
                        }
                        break;
                    case "Web":
                        if (candidatoNovoWeb == null) {
                            candidatoNovoWeb = candidato;
                        }
                        if (candidato.getIdade()<=candidatoNovoWeb.getIdade()){
                            candidatoNovoWeb = candidato;
                        }
                        break;
                    case "Mobile":
                        if (candidatoNovoMobile == null) {
                            candidatoNovoMobile = candidato;
                        }
                        if (candidato.getIdade()<=candidatoNovoMobile.getIdade()){
                            candidatoNovoMobile = candidato;
                        }
                        break;
                }
            }
            System.out.println("Idade do Candidato mais novo Qa:" + candidatoNovoQa.getIdade());
            System.out.println("Idade do Candidato mais novo Web:" + candidatoNovoWeb.getIdade());
            System.out.println("Idade do Candidato mais novo Mobile:" + candidatoNovoMobile.getIdade());
        }

        public static void somaIdades(List<Candidatos> candidatos){
            int countQa = 0;
            int countWeb = 0;
            int countMobile = 0;
            for (Candidatos candidato : candidatos) {
                switch (candidato.getVaga()){
                    case "QA":
                        countQa += candidato.getIdade();
                        break;
                    case "Web":
                        countWeb += candidato.getIdade();
                        break;
                    case "Mobile":
                        countMobile += candidato.getIdade();
                        break;
                }
            }
            System.out.println("Soma das idades dos candidatos Qa:" + countQa);
            System.out.println("Soma das idades dos candidatos Web:" + countWeb);
            System.out.println("Soma das idades dos candidatos Mobile:" + countMobile);
        }

        public static void mostrarEstadosDistintos(List<Candidatos> candidatos){
            Set<String> estadosDistintos = new HashSet<>();
            for (Candidatos candidato : candidatos) {
                estadosDistintos.add(candidato.getEstado());
            }
            System.out.println("Estados distintos: " + estadosDistintos.toString());
            System.out.println("Quantidade de estados distintos: " + estadosDistintos.size());
        }

        public static void gerarCandidatosOrdenados(List<Candidatos> candidatos){
            String nomeArquivo = "Sorted_Academy_Candidates.csv";
            try(FileWriter writer = new FileWriter(nomeArquivo)){
                writer.append("Nome;Idade;Vaga;Estado\n");
                Collections.sort(candidatos, Comparator.comparing(Candidatos::getNome));
                for (Candidatos candidato : candidatos) {
                    writer.append(candidato.getNome() + ";");
                    writer.append(candidato.getIdade() + ";");
                    writer.append(candidato.getVaga() + ";");
                    writer.append(candidato.getEstado() + ";");
                    writer.append("\n");
                }
                System.out.println("Arquivo " + nomeArquivo + " foi gerado com sucesso!!!");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public static void findInstrutorQA(List<Candidatos> candidatos){
            for (Candidatos candidato : candidatos) {
                if (candidato.getVaga().equals("QA")
                        && candidato.getEstado().equals("SC")
                        && candidato.getIdade() == 25
                        && verificarPalindromo(candidato.getNome().split(" ")[0])){
                    System.out.println("O intrutor QA é o: "+candidato.toString());

                }
            }
        }

        public static void findInstrutorMobile(List<Candidatos> candidatos){
        for (Candidatos candidato : candidatos) {
            String firstLetterLastName = Character.toString(candidato.getNome().split(" ")[1].charAt(0)) ;
            if (candidato.getVaga().equals("Mobile")
                    && candidato.getEstado().equals("PI")
                    && candidato.getIdade()>=30 && candidato.getIdade()<=40
                    && candidato.getIdade()%2==0
                    && firstLetterLastName.equalsIgnoreCase("c")){
                System.out.println("O intrutor Mobile é o: "+candidato.toString());

            }
        }
    }

        public static boolean verificarPalindromo(String nome){
            String nomeInverso = new StringBuilder(nome).reverse().toString();
            return nome.equalsIgnoreCase(nomeInverso);
    }

}