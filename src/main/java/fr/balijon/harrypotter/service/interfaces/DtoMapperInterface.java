package fr.balijon.harrypotter.service.interfaces;

public interface DtoMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);
}
