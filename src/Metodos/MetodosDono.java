package Metodos;

import Exceptions.AlterarDadosException;
import Exceptions.JaExisteCarroException;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;
import Entidades.*;

public class MetodosDono {

    public static Carro selectCarroPorMatricula(String matricula) {
        for (Carro u : Repositorio.getInstance().getCarros()) {
            if (u.getMatricula().equals(matricula)) {
                return u;
            }
        }

        return null;
    }

    public static void alterarDadosCarro(Carro carro) throws AlterarDadosException {
        for (Carro u : Repositorio.getInstance().getCarros()) {
            if (u.getMatricula().equals(carro.getMatricula()) && u.getMatricula() == carro.getMatricula()) {
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
            if (u.getMatricula().equals(carro.getMatricula()) || u.getMarca() == carro.getMarca()) {
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
        Repositorio.getInstance().getCarros().remove(carro);
        RepositorioSerializable.writeCarros();
    }
}
