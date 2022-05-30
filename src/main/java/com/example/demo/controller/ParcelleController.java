package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;

@RestController
@RequestMapping("parcelle")
public class ParcelleController {
    @Autowired
    private ParcelleRepository parcelleRepository;
    @Autowired
    private PlanteRepository planteRepository;
    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private PlantageRepository plantageRepository;
    @Autowired
    private FermeRepository fermeRepository;
    @Autowired
    private TYpeSoleRepository tYpeSoleRepository;
    @Autowired
    private GrandeurRepository grandeurRepository;
    @Autowired
    private TypePlanteRepository typePlanteRepository;

    @GetMapping("/all")
    public List<Parcelle> findAll() {
        return parcelleRepository.findAll();
    }

    @GetMapping(value = "/count")
    public int count() {
        int i = 0;
        for (Parcelle parcelle : parcelleRepository.findAll()) {
            ++i;
        }
        return i;
    }

    @GetMapping(value = "/{id}")
    public Optional<Parcelle> findByCode(@PathVariable final int id) {
        return parcelleRepository.findById(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody final Parcelle parcelle) {
        parcelleRepository.save(parcelle);
    }

    // add new parcelle
    @PostMapping(value = "/saves")
    public void saves(@RequestBody Parcelle parcelle) {
        Ferme fi = new Ferme();
        TypeSole ti = new TypeSole();
        for (Ferme f : fermeRepository.findAll()) {
            if (f.getId() == parcelle.getFerme().getId()) {
                fi = f;
            }
        }
        for (TypeSole t : tYpeSoleRepository.findAll()) {
            if (t.getId() == parcelle.getTypeSole().getId()) {
                ti = t;
            }
        }
        Parcelle p = new Parcelle(parcelle.getSurface(), parcelle.getPhoto(), fi, ti);
        parcelleRepository.save(p);

    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable(required = true) int id) {
        parcelleRepository.deleteById(id);
    }

    //charger list parcelle par id ferme
    @GetMapping(value = "/spparcelles/{id}")
    public List<Parcelle> spparcelles(@PathVariable(required = true) int id) {
        List<Parcelle> parcelles = new ArrayList<>();
        for (Parcelle parcelle : parcelleRepository.findAll()) {
            if (parcelle.getFerme().getId() == id) {
                parcelles.add(parcelle);
            }

        }
        return parcelles;
    }

    //nbr parcelle par ferme
    @GetMapping("/countparcelle")
    public Map<String, Integer> countparcelle() {
        Map<String, Integer> map = new HashMap<>();
        for (Ferme f : fermeRepository.findAll()) {
            int nbr_parcelle = 0;
            for (Parcelle p : parcelleRepository.findAll()) {
                if (f.getId() == p.getFerme().getId()) {
                    nbr_parcelle++;
                }

            }
            map.put("ferme N" + f.getId(), nbr_parcelle);
        }
        return map;
    }

    //nbr arosage par parcelle
    @GetMapping("/countarosage")
    public Map<String, Integer> countarosage() {
        Map<String, Integer> maps = new HashMap<>();
        int nbr_arosage = 0;
        for (Parcelle parcelle : parcelleRepository.findAll()) {
            nbr_arosage = 0;
            for (TypePlante p : typePlanteRepository.findAll()) {

                for (Grandeur f : grandeurRepository.findAll()) {

                    if (f.getType().equals("humedite") && f.getParcelle().getId() == parcelle.getId()) {
                        {
                            if (p.getHumiditeMin() >= f.getValeur()) {
                                nbr_arosage++;
                            }
                        }

                    }

                }

            }
            maps.put("parcelle N" + parcelle.getId(), nbr_arosage);
        }
        //trier
        Map<String, Integer> map = new TreeMap<String, Integer>(maps);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //end tri
        return map;
    }

    //EvaluTemp
    @GetMapping(value = "/EvaluTemp/{id}")
    public Map<String, Float> EvaluTemp(@PathVariable(required = true) int id) {
        Map<String, Float> maps = new HashMap<>();

        for (Parcelle parcelle : parcelleRepository.findAll()) {
            if (parcelle.getFerme().getId() == id) {
                for (Grandeur grandeur : grandeurRepository.findAll()) {
                    if (grandeur.getParcelle().getId() == parcelle.getId() && grandeur.getType().equals("temperature")) {
                        //formater date :
                        String pattern = "dd-MM-yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        String date = simpleDateFormat.format(grandeur.getDate());

                        maps.put(date, grandeur.getValeur());
                    }

                }
            }

        }

        //trier
        Map<String, Float> map = new TreeMap<String, Float>(maps);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //end tri

        return map;
    }

    //get nbr arosage par parcelle id
    public int get_nbr_arosage(int id) {
        int nbr_arosage = 0;
        for (Parcelle parcelle : parcelleRepository.findAll()) {
            if (parcelle.getId() == id) {
                for (TypePlante p : typePlanteRepository.findAll()) {
                    nbr_arosage = 0;
                    for (Grandeur f : grandeurRepository.findAll()) {

                        if (f.getType().equals("humedite") && f.getParcelle().getId() == parcelle.getId()) {
                            {
                                if (p.getHumiditeMin() >= f.getValeur()) {
                                    nbr_arosage++;
                                }
                            }

                        }

                    }

                }
            }


        }
        return nbr_arosage;
    }


    //EvaluConsomation parcele par date
    @GetMapping(value = "/ConsomationParcell/{id}")
    public Map<String, Float> ConsomationParcell(@PathVariable(required = true) int id) {
        Map<String, Float> maps = new HashMap<>();
        int cpt = 0;
        for (Grandeur grandeur : grandeurRepository.findAll()) {
            if (grandeur.getType().equals("humedite") && grandeur.getParcelle().getId() == id) {
                for (Plantage plantage : plantageRepository.findAll()) {
                    if (plantage.getParcelle().getId() == id) {
                        for (Plante plante : planteRepository.findAll()) {
                            if (plantage.getPlante().getId() == plante.getId()) {
                                for (TypePlante typePlante : typePlanteRepository.findAll()) {

                                    if (typePlante.getId() == plante.getTypePlante().getId()) {
                                        int nbrplante = plantage.getNbrplante();
                                        float besoinDeau = typePlante.getBesoinDeau();
                                        float valeurhumedite = grandeur.getValeur();
                                        float humedite_min = typePlante.getHumiditeMin();
                                        Date datearosage = grandeur.getDate();
                                        //formule
                                        float test = besoinDeau;
                                        float nbrlitreConsommer = nbrplante * besoinDeau;
                                        //formater date :
                                        String pattern = "dd-MM-yyyy";
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                        String date = simpleDateFormat.format(datearosage);
                                        cpt += 10;
                                        maps.put(date, test + cpt);

                                    }

                                }


                            }

                        }
                    }

                }
            }

        }
        //trier
        Map<String, Float> map = new TreeMap<String, Float>(maps);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //end tri
        return maps;
    }

    //EvaluHum
    @GetMapping(value = "/EvaluHum/{id}")
    public Map<String, Float> EvaluHum(@PathVariable(required = true) int id) {
        Map<String, Float> maps = new HashMap<>();

        for (Parcelle parcelle : parcelleRepository.findAll()) {
            if (parcelle.getFerme().getId() == id) {
                for (Grandeur grandeur : grandeurRepository.findAll()) {
                    if (grandeur.getParcelle().getId() == parcelle.getId() && grandeur.getType().equals("humedite")) {
                        //formater date :
                        String pattern = "dd-MM-yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        String date = simpleDateFormat.format(grandeur.getDate());

                        maps.put(date, grandeur.getValeur());
                    }

                }
            }

        }
        //trier
        Map<String, Float> map = new TreeMap<String, Float>(maps);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //end tri
        return map;
    }


    //alert
    @GetMapping("/getAlerts")
    public List<Alert> getAlerts() {
        alertRepository.deleteAll();
        Grandeur ggar = new Grandeur();
        for (Parcelle parcelle : parcelleRepository.findAll()) {
            for (TypePlante typePlante : typePlanteRepository.findAll()) {

                for (Grandeur grandeur : grandeurRepository.findAll()) {
                    //humidite
                    if (grandeur.getType().equals("humedite") && grandeur.getParcelle().getId() == parcelle.getId()) {

                        if (typePlante.getHumiditeMin() >= grandeur.getValeur()) {

                            if (ggar != grandeur) {
                                // humidite, Float temperature, Float luminosite, Date date, Parcelle parcelle
                                alertRepository.save(new Alert(grandeur.getValeur(), null, null, grandeur.getDate(), parcelle));

                            }

                            ggar = grandeur;
                        }

                    }
                    //temperature
                    if (grandeur.getType().equals("temperature") && grandeur.getParcelle().getId() == parcelle.getId()) {
                        if (typePlante.getTemperatureMax() <= grandeur.getValeur() || typePlante.getTemperatureMin() >= grandeur.getValeur()) {
                            // humidite, Float temperature, Float luminosite, Date date, Parcelle parcelle
                            alertRepository.save(new Alert(null, grandeur.getValeur(), null, grandeur.getDate(), parcelle));

                        }
                    }
                    //luminosite
                    if (grandeur.getType().equals("luminosite") && grandeur.getParcelle().getId() == parcelle.getId()) {
                        if (typePlante.getLuminosite() >= grandeur.getValeur() || typePlante.getLuminosite() <= grandeur.getValeur()) {
                            // humidite, Float temperature, Float luminosite, Date date, Parcelle parcelle
                            alertRepository.save(new Alert(null, null, grandeur.getValeur(), grandeur.getDate(), parcelle));
                            break;
                        }
                    }
                }
                break;
            }

        }

        return alertRepository.findAll();
    }


}
