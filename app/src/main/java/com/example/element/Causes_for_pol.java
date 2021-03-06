package com.example.element;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Causes_for_pol extends AppCompatActivity {

    ViewPager viewPager;
    Adapter2 adapter2;
    List<Design> designs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causes_for_pol);

        designs = new ArrayList<>();
        designs.add(new Design("Industrial Waste" , "Industrial waste is defined as waste generated by manufacturing or industrial processes.The types of industrial waste generated include cafeteria garbage, dirt and gravel, masonry and concrete, scrap metals, trash, oil, solvents, chemicals, weed grass and trees, wood and scrap lumber, and similar wastes."));
        designs.add(new Design("Sewage and Wastewater", "Sewage is the term used for wastewater that often contains faeces, urine and laundry waste. There are billions of people on Earth, so treating sewage is a big priority. Sewage disposal is a major problem in developing countries as many people in these areas don't have access to sanitary conditions and clean water."));
        designs.add(new Design("Mining Activities", "Mining affects fresh water through heavy use of water in processing ore, and through water pollution from discharged mine effluent and seepage from tailings and waste rock impoundments. Increasingly, human activities such as mining threaten the water sources on which we all depend."));
        designs.add(new Design("Marine Dumping", "Marine Dumping has been defined as the deliberate disposal at sea of wastes or other matter from vessels, aircraft, platforms or other man-made structures, as well as the deliberate disposal of these vessels or platforms themselves."));
        designs.add(new Design("Accidental Oil Leakage", "Oceans are polluted by oil on a daily basis from oil spills, routine shipping, run-offs and dumping.Oil cannot dissolve in water and forms a thick sludge in the water. This suffocates fish, gets caught in the feathers of marine birds stopping them from flying and blocks light from photosynthetic aquatic plants."));
        designs.add(new Design("The burning of fossil fuels", "Cars and trucks release nitrogen into the atmosphere, which contributes to nutrient pollution in our air and water. When fossil fuels are burned, they release nitrogen oxides into the atmosphere, which contribute to the formation of smog and acid rain."));
        designs.add(new Design("Leakage From Sewer Lines", "Among the most well-known causes of water contamination are hazardous waste materials from sewage or septic systems. If your sewage pipes are damaged, human waste products seep out and end up in nearby groundwater."));
        designs.add(new Design("Global Warming", "Climate change is causing air temperature to rise, which provokes corresponding water temperature increases in lakes, reservoirs, and streams.Higher water temperatures are associated with reduced levels of dissolved oxygen in bodies of water. Lower oxygen levels place significant stress on aquatic animals."));
        designs.add(new Design("Radioactive Waste", "Nuclear waste is produced from industrial, medical and scientific processes that use radioactive material. Nuclear waste can have detrimental effects on marine habitats."));
        designs.add(new Design("Urban Development", "Urban areas have the potential to pollute water in many ways.Groundwater and surface water can be contaminated from many sources such as garbage dumps, toxic waste and chemical storage and use areas, leaking fuel storage tanks, and intentional dumping of hazardous substances."));
        designs.add(new Design("Leakage From the Landfills", "The most serious form of water pollution from landfills is direct leachate contamination, considered a major environmental and human-health hazard. Leachate is a highly odorous black or brown liquid that commonly contains heavy metals, such a lead, and volatile organic compounds or VOCs."));
        designs.add(new Design("Animal Waste", "Pollutants in animal waste can impact waters through several possible pathways, including surface runoff and erosion, direct discharges to surface waters, spills and other dry-weather discharges, leaching into soil and groundwater, and releases to air."));
        designs.add(new Design("Underground Storage Leakage", "Underground storage tanks hold toxic material, such as gasoline and waste oil, which contain dangerous substances that can cause cancer and harm developing children. Chemicals in USTs can quickly move through soil and pollute groundwater. There is no safe level of exposure to many of these toxic substances."));
        designs.add(new Design("Eutrophication", "Eutrophication is when the environment becomes enriched with nutrients. The algae may use up all the oxygen in the water, leaving none for other marine life. ... This results in the death of many aquatic organisms such as fish, which need the oxygen in the water to live."));
        designs.add(new Design("Acid Rain", "Acid rain makes such waters more acidic, which results in more aluminum absorption from soil, which is carried into lakes and streams. That combination makes waters toxic to crayfish, clams, fish, and other aquatic animals."));


        adapter2 = new Adapter2(designs , this);

        viewPager = findViewById(R.id.viewPager2);
        viewPager.setAdapter(adapter2);
        viewPager.setPadding(130, 0, 130, 0);

    }
}