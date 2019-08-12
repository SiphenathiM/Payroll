package ac.za.cput.service;

import ac.za.cput.domain.Gender;

import java.util.Set;

public interface GenderService extends IService < Gender,String > {
    Set<Gender> getAll();
}
