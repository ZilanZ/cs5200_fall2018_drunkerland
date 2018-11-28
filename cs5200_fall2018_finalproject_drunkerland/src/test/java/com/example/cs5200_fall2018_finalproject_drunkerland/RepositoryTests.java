package com.example.cs5200_fall2018_finalproject_drunkerland;

import com.example.cs5200_fall2018_finalproject_drunkerland.models.Package;
import com.example.cs5200_fall2018_finalproject_drunkerland.repositories.PackageRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryTests extends DemoApplicationTests {

    @Autowired
    PackageRepository packageRepository;

    @Test
    public void insertPackage() {
        Package pkg = new Package("00000234", Package.PackageStatus.INTRANSIT);
        packageRepository.save(pkg);
    }
}
