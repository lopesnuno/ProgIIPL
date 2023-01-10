package Metodos;

import Entidades.Carro;
import Estados.Estados;
import Exceptions.AlterarDadosException;
import Exceptions.JaExisteCarroException;
import Repositorio.*;

public class MetodosCarro {
    public static Carro selectCarroPorMatriucla(String matricula) {
        for (Carro c : Repositorio.getInstance().getCarros()) {
            if (c.getMatricula().equals(matricula)) {
                return c;
            }
        }

        return null;
    }

    public static void alterarDadosCarro(Carro carro) throws AlterarDadosException {
        for (Carro u : Repositorio.getInstance().getCarros()) {
            if (u.getMatricula().equals(carro.getMatricula())) {
                u.setMatricula(carro.getMatricula());
                u.setMarca(carro.getMarca());
                u.setModelo(carro.getModelo());
                u.setAno(carro.getAno());
                u.setPreco(carro.getPreco());
                return;
            }
        }

        throw new AlterarDadosException("Não foi possível encontrar o carro que queria alterar.");
    }

    public static void addCarro(Carro carro) throws JaExisteCarroException {
        boolean existe = false;
        for (Carro u : Repositorio.getInstance().getCarros()) {
            if (u.getMatricula().equals(carro.getMatricula())) {
                existe = true;
                break;
            }
        }

        if (existe) {
            throw new JaExisteCarroException("Este Carro já existe !");
        } else {
            Repositorio.getInstance().getCarros().add(carro);
            RepositorioSerializable.writeCarros();
        }
    }

    public static void removerCarro(Carro carro) {
        for (Carro c : Repositorio.getInstance().getCarros()) {
            if (c.getMatricula().equals(carro.getMatricula())) {
                c.setEstado(Estados.DESATIVADO);
                RepositorioSerializable.writeCarros();
            }
        }
    }
}
