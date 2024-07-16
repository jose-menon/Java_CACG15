package com.example.G15CAC.Repository;

import com.example.G15CAC.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository

public interface Repository extends JpaRepository<Persona, Long>
{

}
