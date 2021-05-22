package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

import io.github.kexanie.library.MathView;

public class Formulas extends Activity {

    private AdView FormAdView;
    InterstitialAd formInterAd;

    int formulaSize = 0;
    String formulaNames[];
    String formulas[];

    TextView chapterName;
    ArrayList<String> formulaName;
    ArrayList<String> formula;
    RecyclerView mRecyclerView;
    MathView formulaView;

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////  PHYSICS
    //////////////////////////////////////////////////

    String phyKinematsName[] = {"Speed & Velocity", "Acceleration","Equations of Uniformly Accelerated Motion", "Distance Travelled in n-th Second", "Motion Under Gravity",
            "Time of Flight of Projectile Motion", "Maximum Height", "Horizontal Range", "Projectile Motion on Inclined Plane",
            "Kinetic Equations in Circular Motion", "Centripetal Force and Turns at Road", "Non Uniform Horizontal Circular Motion"};
    String phyKinemats[] = {"$$\\ Speed = \\frac{Distance}{Time}$$ $$\\ Velocity = \\frac{Displacement}{Time} $$ $$\\ Average Vel. = \\frac{Total Disp.}{Total Time} $$ $$\\ V_{ab} = V_a - V_b $$",
            "$$\\ a = \\frac{ \\Delta v}{ \\Delta t} $$",
            "$$\\ 1) v = u + at $$ $$\\ 2) s = ut + \\frac{1}{2} at^2 $$ $$\\ 3) v^2 - u^2 = 2as $$",
            "$$\\ S_{nth} = u + \\frac{a}{2} (2n - 1) $$",
            "$$\\ t_A = \\frac{u}{g} = \\sqrt{\\frac{2h}{g}}$$ $$\\ h_{max} = \\frac{u^2}{2g}$$",
            "$$\\ T = \\frac{2u \\sin \\theta}{g} $$",
            "$$\\ H = \\frac{u^2 \\sin^2 \\theta}{2g} $$",
            "$$\\ R = \\frac{u^2 \\sin2 \\theta}{g} $$",
            "$$\\ T = \\frac{2u \\sin( \\alpha - \\beta)}{g \\cos \\beta} $$ $$\\ R = \\frac{2u^2 \\sin( \\alpha - \\beta) \\cos \\alpha}{g \\cos \\beta} $$ $$\\ x = \\frac{2u^2 \\sin(\\alpha - \\beta) \\cos \\alpha}{g \\cos^2 \\beta} $$ $$\\ R_{max} = \\frac{u^2}{g(1 + \\sin \\beta)} $$ $$\\ \\alpha = 45^ \\circ + \\frac{\\beta}{2} $$",
            "$$\\ 1) \\omega = \\omega_{ \\circ} + \\alpha t $$ $$\\ 2) \\theta = \\omega_{ \\circ} t + \\frac{1}{2} \\alpha t^2 $$ $$\\ 3) \\omega ^2 = \\omega^2 _{ \\circ} + 2 \\alpha \\theta $$",
            "$$\\ F = \\frac{mv^2}{r} $$ $$\\ \\mu \\ge \\frac{v^2}{rg} $$ $$\\ or $$ $$\\ v \\ge \\sqrt{ \\mu_s rg} $$ $$\\ v_{max} = \\sqrt{ \\frac{rg( \\mu + \\tan \\theta)}{(1 - \\mu \\tan \\theta)}} $$",
            "$$\\ a = \\sqrt{a^{2}_R + a^{2}_T} $$ $$\\ \\tan \\phi = \\frac{a_T}{a_R} = \\frac {r^2 a}{v^2} $$"};

    String phyLawsOfMotionNames[] = {"Newton's Second Law of Motion", "Newton's Third Law of Motion", "Static Friction", "Kinetic Friction", "Spring Force", "Centripetal Force", "Tangential Force"};
    String phyLawsOfMotion[] = {"$$\\ \\vec F = \\frac{d \\vec p}{dt} = m \\frac {d \\vec v}{dt} = m \\vec a $$", "$$\\ \\vec F_{reaction} = - \\vec F_{action} $$", "$$\\ F_{static} = \\mu _ {static} N $$",
            "$$\\ F_{kinetic} = \\mu _ {kinetic} N $$","$$\\ F_{restoring} = -kx $$","$$\\ F_{radial} = m \\omega^2 r = m \\frac{v^2}{r} $$","$$\\ \\vec F_{tangent} = m \\vec a_{tangent} $$"};

    String phyWPENames[] = {"Work Done by a Force", "Kinetic Energy", "Potential Energy", "Gravitational Potential Energy",
            "Elastic Potential Energy", "Power of Force", "Minimum Velocity at top of Vertical", "Conservation of Momentum",
            "Restitution", "Center of Mass",};
    String phyWPE[] = {"$$\\ W = \\vec F . \\vec s $$", "$$\\ KE = \\frac {1}{2} m v^2 $$", "$$\\ U_b - U_a = - \\int_a ^b \\vec F (s). d \\vec s = -W $$", "$$\\ GPE = m g h $$",
            "$$\\ EPE = \\frac{1}{2} kx^2 $$", "$$ \\ P = \\frac {dW}{dt} \\vec F . \\frac{d \\vec s}{dt}= \\vec F \\vec v $$", "$$\\ V_{top} \\ge \\sqrt {gl} $$", "$$\\ m_a \\vec u_a + m_b \\vec u_b =  m_a \\vec v_a + m_b \\vec v_b $$",
            "$$\\ \\vec v_b - \\vec u-a = e( \\vec u_a - \\vec u_a - \\vec u_b) $$", " $$\\ Center \\; of \\; Mass $$ $$\\ For \\; Discrete \\; Mass \\; Distribution $$ $$\\ \\vec x_{cm} = \\frac{m_1 \\vec x_1 + m_2 \\vec x_2 + m_3 \\vec x_3 + ....}{m_1 + m_2 + m_3 + ....} $$ $$\\ For \\; Continuous \\; Mass \\; Distribution $$ $$\\ x_{cm} = \\frac {\\int xdm}{\\int dm} $$"};

    String phyRMotionNames[] = {"Center of Mass of n-Particle System", "Equation of Rotational Motion", "Torque", "Angular Momentum",
            "Conservation of Angular Momentum", "Angular Impulse", "Acceleration of the Body", "Velocity Attained at the Bottom",
            "Time to Reach the Bottom", "Total Kinetic Energy of a Rolling Body", "Power Delivered by Torque", "Work Done by Torque"};
    String phyRMotion[] = {"$$\\ r_{cm} = \\frac{m_1 r_1 + m_2 r_2 + m_3 r_3 + ....}{m_1 + m_2 + m_3 + ....} $$", "$$\\ 1) \\omega = \\omega_{ \\circ} + \\alpha t $$ $$\\ 2) \\theta = \\omega_{ \\circ} t + \\frac{1}{2} \\alpha t^2 $$ $$\\ 3) \\omega ^2 = \\omega^2 _{ \\circ} + 2 \\alpha \\theta $$", "$$\\ T = r \\times F = rF \\sin \\theta n = I \\alpha $$", "$$\\ Scalar \\; Form $$ $$\\ L = I \\omega = mvr $$ $$\\ Vector \\; Form $$ $$\\ L = \\vec r X m \\vec v $$",
            "$$\\ If \\; T_{ext} = U , \\; then \\; L = Const. $$ $$\\ i.e. $$ $$\\ I_1 \\omega_1 = I_2 \\omega_2 $$", "$$\\ J = \\int _{ \\delta L} ^0 \\; T.dt = L_f - L_i $$", "$$\\ a = \\frac {g \\sin \\theta}{1 + \\frac{K^2}{r^2}} $$", "$$\\ v = \\sqrt{ \\frac {2gh}{1 + \\frac{K^2}{r^2}}} $$",
            "$$\\ T = \\sqrt{ \\frac {2s(1 + \\frac{K^2}{r^2})}{g \\sin \\theta}} $$", "$$\\ KE_{total} = \\frac{1}{2} mv^2 + \\frac {1}{2} I \\omega^2 $$", "$$\\ P = T. \\omega $$", "$$\\ W = T. \\theta $$"};

    String phyGravitationNames[] = {"Gravitational Force", "Variation in 'G' with shape of Earth", "Variation of 'G' with Rotation of Earth", "Variation of 'G' with Altitude",
            "Variation of 'G' with Depth", "Intensity of Gravitational Field", "Gravitational Potential", "Gravitational Potential Energy",
            "Time Period of a Satellite", "Orbital Velocity", "Total Energy of a Satellite", "Binding Energy of Satellite", "Escape Velocity"};
    String phyGravitation[] = {"$$\\ F = \\frac {G m_1 m_2}{r^2} $$", "$$\\ g \\; \\alpha \\; \\frac {1}{R^2} $$", "$$\\ g' = g - R \\omega ^2 \\cos ^2 L $$", "$$\\ g' = \\frac {g}{(1 + \\frac {h}{R})^2} $$",
            "$$\\ g' = g(1 - \\frac {h}{R}) $$", "$$\\ I = - \\frac{GM}{r^2} $$", "$$\\ V = - \\frac {GM}{r} $$", "$$\\ U = - \\frac{GMm}{r} $$",
            "$$\\ T = 2 \\pi \\sqrt{ \\frac{r^3}{GM}} = \\frac {2 \\pi}{r} \\sqrt{ \\frac {(R + h)^3}{g}} $$", "$$\\ v_ \\circ = \\sqrt{ \\frac {GM}{R + h}} $$", "$$\\ E = - \\frac {GMm}{2r} $$", "$$\\ B.E = \\frac {GMm}{2r} $$", "$$\\ v_e = \\sqrt{ \\frac {2GM}{R}} = \\sqrt{2gR} $$"};

    String phyThermoNames[] = {"First Law of Thermodynamics", "Change in Heat", "Change in Internal Energy", "Work done in Isothermal Process",
            "Work done in Adiabatic Process", "Poisson's Law", "Work done in Isobaric Process", "Work done in Isochoric process",
            "Entropy", "Efficiency of Heat Engine", "Co-Efficient of Performance"};
    String phyThermo[] = {"$$\\ q = \\Delta U + W $$", "$$\\ dQ = dC_p dT $$", "$$\\ dU = nC_v dt $$", "$$\\ W = 2.303 nRT \\log {10} \\frac {V_f}{V_i} $$",
            "$$\\ W = \\frac {nR(T_i - T_f)}{ \\gamma - 1} = \\frac {P_iV_i - P_fV_f}{ \\gamma - 1} $$", "$$\\ PV^ { \\gamma} = TV^{ \\gamma - 1} = T^{ \\gamma} P ^{1 - \\gamma} $$", "$$\\ W = P \\delta V $$", "$$\\ W = 0 $$",
            "$$\\ dS = \\frac {dQ}{T} $$", "$$\\ n = 1 - \\frac {Q_2}{Q_1} = 1 - \\frac {T_2}{T_1} $$", "$$\\ \\beta = \\frac {Q_2}{Q_1 - Q_2} = \\frac {T_2}{T_1 - T_2} $$"};

    String phyKinTheoryNames[] = {"Ideal Gas Equation", "Real Gas Equation", "Pressure due to an Ideal Gas", "Avg. KE of Gas",
            "RMS velocity of Gas Molecules", "Avg. Speed of a Gas Molecules", "Most Probable Speed og Gas Molecules", "Specific Heat of Gas",
            "Ratio of Specific Heats", "Mean Free Path"};
    String phyKinTheory[] = {"$$\\ pV = nRT $$", "$$\\ (p + \\frac {an^2}{V^2}) (V - nb) = nRT $$", "$$\\ p = \\frac {1}{3} \\frac {mnc^2}{V} = \\frac {1}{3} pc^2 $$", "$$\\ E = \\frac {3}{2} RT $$",
            "$$\\ c = \\sqrt{ \\frac {3RT}{M}} = \\sqrt{ \\frac{3P}{p}} $$", "$$\\ V_{avg} = \\sqrt{ \\frac{8RT}{ \\pi M}} $$", "$$\\ V_{mp} = \\sqrt{ \\frac {2RT}{M}} $$", "$$\\ C_v = f \\frac{R}{2} $$",
            "$$\\ \\gamma = 1 + \\frac {2}{f} = \\frac {C_p}{C_v} $$", "$$\\ \\lambda = \\frac {kT}{ \\sqrt{2} \\pi \\sigma ^2 p} $$"};

    String phyPropMatterNames[] = {"Hooke's Law", "Young's Mudulus of Elasticity", "Bulk Modulus of Elasticity", "Modulus of Rigidity",
            "Elastic Potential Energy stored in Stretched Wire", "Thermal Stress", "Poisson's Ratio", "Cantilever",
            "Beam supported at Two Ends", "Torsion of a Cylinder", "Pressure Exerted by a Liquid", "Archimede's Principle",
            "Density of Mixture of Substances", "Viscous Forcs", "Variation of Viscousity", "Poiseuille's Formula",
            "Stoke's Law", "Reynold's No.", "Equation of Continuity", "Bernoulli's Theorem",
            "Venturimeter", "Torricelli's Law", "Surface Energy", "Capillary Tube Action",
            "Thermal Expansion of Solids", "Specific Heat & Water Equivalent"};
    String phyPropMatter[] = {"$$\\ Stress = \\frac {Restoring \\; Force}{Area} $$ $$\\ Strain = \\frac {Change \\; in \\; Configuration}{Original \\; Configuration} $$ $$\\ Hooke's \\; Law \\; States \\; that : $$ $$\\ Stress \\; \\alpha \\; Strain $$ $$\\ Stress = E \\times Strain $$", "$$\\ Y = \\frac {Normal \\; Stress}{Longitudinal \\; Strain} $$ $$\\ Y = \\frac {Fl}{A \\Delta l}  = \\frac {mgl}{ \\pi r^2 \\Delta l}$$", "$$\\ K = \\frac {Normal \\; Stress}{Volumetric \\; Strain} $$ $$\\ K = \\frac {FV}{A \\Delta V} $$", "$$\\ n = \\frac {Tangential \\; Stress}{Shearing \\; Strain} $$ $$\\ n = \\frac {F}{A \\theta} $$",
            "$$\\ Elastic \\; PE \\; Per \\; Unit \\; Volume $$ $$\\ U = \\frac {1}{2} \\times Stress \\times Strain $$ $$\\ PE \\; Stored \\; in \\; Stretched \\; Wire $$ $$\\ U = \\frac {1}{2} F \\Delta l $$", "$$\\ Thermal \\; Stress = \\frac {F}{A} = Y \\alpha \\Delta \\theta $$", "$$\\ Poisson's \\; Ratio = \\frac {Lateral \\; Strain}{Longitudinal \\; Strain} $$ $$\\ \\sigma = \\frac { \\frac { - \\Delta R}{R}}{ \\frac { \\Delta l}{l}} $$", "$$\\ \\delta = \\frac {wl^3}{3YI_G} $$",
            "$$\\ \\delta = \\frac {wl^3}{48 \\; YI_G} $$", "$$\\ C = \\frac { \\pi n r^4}{2l} $$ $$\\ W = \\frac {1}{2} C \\theta^2 $$ $$\\ r \\theta = l \\phi $$", "$$\\ P = h \\rho g $$", "$$\\ W = \\frac {T}{(1 - \\frac { \\rho}{ \\sigma})} $$",
            "$$\\ \\rho = \\frac {m_1 + m_2}{ \\frac {m_1}{ \\rho_1} + \\frac {m_2}{ \\rho_2}} $$", "$$\\ F = -nA \\frac {dV}{dx} $$", "$$\\ n_t = \\frac {n_ \\circ}{1 + \\alpha t + \\beta t^2} $$", "$$\\ v = \\frac { \\pi}{8} . \\frac {pr^4}{nl} $$",
            "$$\\ F = 6 \\pi n r v $$ $$\\ v = \\frac {2}{9} \\frac {r^2( \\rho - \\sigma)g}{n} $$", "$$\\ K = \\frac {v_c \\rho r}{n} $$", "$$\\ AV = Constant $$ $$\\ a_1v_1 = a_2v_2 $$", "$$\\ p + \\frac {1}{2} \\rho v^2 + \\rho gh = Const. $$",
            "$$\\ v = a_1a_2 \\sqrt{ \\frac {2gh}{a^2 _1 - a^2 _2}} $$", "$$\\ v = \\sqrt{2gh} $$ $$\\ S = \\sqrt{4h (H - h)} $$", "$$\\ E = S \\times \\Delta A $$", "$$\\ h = \\frac {2 S \\cos \\theta}{r \\rho g} $$",
            "$$\\ Linear \\; Expansion $$ $$\\ l_2 = l_1(1 + \\alpha \\Delta t) $$ $$\\ Superficial \\; Expansion $$ $$\\ A_2 = A_1 (1 + \\beta \\Delta t) $$ $$\\ Cubical \\; Expansion $$ $$\\ V_2 = V_1 (1 + \\gamma \\Delta t) $$", "$$\\ Q = mc \\Delta t $$ $$\\ H = mc $$ $$\\ W = ms $$ $$\\ Q = mL $$"};

    String phyOscillsNames[] = {"Displacement in SHM", "Velocity of Partical in SHM", "Acceleration in SHM", "Time Period in SHM",
            "Force in SHM", "Energy in SHM", "Time Period of a Simple Pendulum",
            "Second's Pendulum", "Time Period of Conical Pendulum", "Time Period of Compound Pendulum",
            "Time Period of Torsional Pendulum", "Time Period of Physical Pendulum", "Time Period of Spring Pendulum", "Effective Force Constant",
            "Damped Oscillations", "Resultant of Two SHMs"};
    String phyOscills[] = {"$$\\ y = a \\sin \\omega t $$ $$\\ or $$ $$\\ y = a \\cos \\omega t $$", "$$\\ v = \\omega \\sqrt{(a^2 - y^2)} $$ $$\\ v_{max} = a \\omega $$", "$$\\ \\alpha = - \\omega^2 y $$", "$$\\ T = 2 \\pi \\sqrt { \\frac {Displacement}{Acceleration}} $$",
            "$$\\ F = -m \\omega^2x = -kx $$", "$$\\ K = \\frac {1}{2} m \\omega^2 (A^2 - x^2) $$ $$\\ U = \\frac {1}{2} m \\omega^2 x^2 $$ $$\\ E = \\frac{1}{2} m \\omega^2 A^2 $$", "$$\\ T = 2 \\pi \\sqrt { \\frac {1}{g}} $$",
            "$$\\ Time \\; Period = 2 \\; seconds $$ $$\\ Effective \\; Length = 99.992 \\; cm $$", "$$\\ T = 2 \\pi \\sqrt{ \\frac {mr}{T \\sin \\theta}} $$", "$$\\ T = 2 \\pi \\sqrt{ \\frac {I}{mgl}} $$",
            "$$\\ T_T = 2 \\pi \\sqrt{ \\frac {I}{C}} $$", "$$\\ T_P = 2 \\pi \\sqrt{ \\frac {I}{mgd}} $$", "$$\\ T_S = 2 \\pi \\sqrt{ \\frac {m}{k}} $$", "$$\\ Springs \\; in \\; Parallel $$ $$\\ k = k_1 + k_2 $$ $$\\ Springs \\; in \\; Series $$ $$\\ \\frac {1}{k} = \\frac {1}{k_1} + \\frac {1}{k_2} $$",
            "$$\\ E = \\frac {1}{2} k x_ \\circ ^2 e^{ \\frac {-bt}{m}} $$", "$$\\ Resultant \\; of \\; two \\; SHMs $$ $$\\ x = a_1 \\sin \\omega t $$ $$\\ \\& $$ $$\\ y = a_2 \\sin ( \\omega t + \\phi) $$ $$\\ = \\frac {x^2}{a_1 ^2} + \\frac {x^2}{a_2 ^2} - \\frac {2xy}{a_1a_2} \\cos \\phi = \\sin^2 \\phi $$"};

    String phyElastNames[] = {"Tensile Strain", "Volume Strain", "Hooke's Law",
                              "Young's Modulus", "Bulk Modulus", "Modulus of Rigidity", "Poisson's Ratio"};
    String phyElast[] = {"$$\\ T.Strain = \\frac { \\Delta l}{l} $$", "$$\\ V.Strain = \\frac { \\Delta V}{V} $$", "$$\\ \\frac {Stress}{Strain} = Const. $$",
                         "$$\\ \\frac {MgL}{ \\pi r^2 l} $$", "$$\\ V \\frac {dP}{dV} $$", "$$\\ \\frac {F}{A \\theta} $$", "$$\\ \\frac {Lateral Strain}{Longitudinal Strain} $$"};


    String phyWavesNames[] = {"Velocity of Longitudinal Waves", "Factors Affecting the Velocity of Longitudinal Waves", "Speed of Transverse Motion", "Beats",
            "Stationary Waves", "Fundamental Frequency", "Vibration in Open & Closed Pipe Organ", "Factors Affecting the Frequency of Pipe",
            "Doppler's Effect"};
    String phyWaves[] = {"$$\\ v = \\sqrt{ \\frac {E}{ \\rho}} $$ $$\\ Newton's Formula $$ $$\\ v = \\sqrt { \\frac {E_T}{ \\rho}} = \\sqrt { \\frac {p}{ \\rho}} $$", "$$\\ Effect \\; of \\; Pressure (No \\; Effect)$$ $$\\ v = \\sqrt{ \\frac {p}{ \\rho}} = \\sqrt { \\frac {RT}{m}} $$ $$\\ Effect \\; of \\; Temperature $$ $$\\ v \\; \\alpha \\; \\sqrt {T} \\rightarrow \\sqrt { \\frac {v_1}{v_2}} = \\sqrt { \\frac {T_1}{T_2}} $$ $$\\ Effect \\; of \\; Density $$ $$\\ v \\; \\alpha \\; \\frac {1}{ \\sqrt { \\rho}} \\rightarrow \\sqrt { \\frac {v_1}{v_2}} = \\sqrt { \\frac { \\rho_2}{ \\rho_1}} $$", "$$\\ On \\; Stretched \\; String $$ $$\\ v = \\sqrt{ \\frac {T}{m}} $$ $$\\ In \\; a \\; Solid $$ $$\\ v = \\sqrt { \\frac {n}{ \\rho}} $$", "$$\\ No. \\; of \\; Beats \\; Heard \\; Per \\; Sec. $$ $$\\ = \\; n_1 - n_2 $$ $$\\ Time \\; Intervals \\; for \\; Loudness $$ $$\\ = \\; \\frac {1}{n_1 - n_2}, \\frac {2}{n_1 - n_2}, \\; .... $$",
            "$$\\ y = 2a \\sin \\frac {2 \\pi t}{T} \\cos \\frac {2 \\pi x}{ \\lambda} $$", "$$\\ n_1 = \\frac {v}{2l} = \\frac {1}{2l} \\sqrt { \\frac {T}{m}} $$", "$$\\ Open \\; Pipe \\; Organ $$ $$\\ n_1 = \\frac {v}{2l}, \\; n_2 = \\frac {2v}{2l} .... $$ $$\\ Closed \\; Pipe \\; Organ $$ $$\\ n_1 = \\frac {v}{4l}, \\; n_2 = \\frac {3v}{4l}.... $$", "$$\\ n \\; \\alpha \\; \\frac {1}{l}, \\; n \\; \\alpha \\; \\frac {1}{r} $$ $$\\ n \\; \\alpha \\; \\frac {1}{ \\sqrt { \\rho}}, \\; n \\; \\alpha \\; \\sqrt { \\rho} $$ $$\\ n \\; \\alpha \\; \\sqrt{T}, \\; n \\; \\alpha \\; v $$",
            "$$\\ From \\; Source \\; to \\; Observer \\; (+ve) $$ $$\\ n' = n . ( \\frac {V - V_ \\circ}{V - V_s}) $$ $$\\ Wind \\; Blowing \\; in \\; Direction \\; of \\; Sound $$ $$\\ n' = n . ( \\frac {V + w - V_circ}{V + w - V_s}) $$"};

    String phyCircMotNames[] = {"Linear Speed of Particle", "Acceleration of Particle in U.C.M", "Time Period of Particle in U.C.M", "Centripetal Force",
                           "Centrifugal Force", "Max. Velocity in which the Vehicle can Safely Turn", "Max. Velocity for Turning in Banked Road", "Period of Conical Pendulum",
                           "Velocity of Bob in Conical Pendulum"};
    String phyCircMot[] = {"$$\\ v = r \\frac{2 \\pi}{T} = 2 \\pi nr $$", "$$\\ a = v \\omega = \\frac {v^2}{r} = r \\omega^2 $$", "$$\\ T = \\frac {2 \\pi}{ \\omega} $$", "$$\\ F_{cp} = \\frac {mv^2}{r} = mr \\omega^2 $$",
                           "$$\\ F_{cf} = \\frac {mv^2}{r} = mr \\omega^2 $$", "$$\\ v = \\sqrt { \\mu rg} $$", "$$\\ v = \\sqrt {rg \\tan \\theta} $$", "$$\\ T = 2 \\pi \\sqrt{ \\frac {r}{g \\tan \\theta}} $$",
                           "$$\\ v = \\sqrt{rg \\tan \\theta} $$"};

    String phyElectrostaticsNames[] = {"Coulomb's Law", "Electric Field in a Region", "Resultant of Electric Fields", "Electric PE betw. Two Charges",
            "Electric Potential due to Point Charge", "Dipole Moment", "Torque on Dipole in Uniform Field", "PE of Dipole in Uniform Electric Field",
            "Gauss Theorem", "Field at Surface of a Conductor", "Capacitance", "Capacitance of a Parallel Plate Conductor",
            "Series Combination of Capacitor", "Parallel Combination of a Conductor", "Energy Stored in Capacitor"};
    String phyElectrostatics[] = {"$$\\ F = \\frac {q_1q_2}{4 \\pi \\varepsilon_ \\circ r^2} $$", "$$\\ \\overline E = \\frac { \\overline F}{q} $$", "$$\\ Superposition \\; Principle $$ $$\\ \\overline E = \\overline E_1 + \\overline E_2 $$", "$$\\ U(r) = \\frac {kq_1q_2}{r}; \\; \\; k = \\frac {1}{4 \\pi \\varepsilon_ \\circ} $$",
            "$$\\ V(r) = \\frac {Q}{4 \\pi \\varepsilon_ \\circ r} $$", "$$\\ \\overline p = q \\overline d $$", "$$\\ \\overline t = \\overline p \\times \\overline E $$", "$$\\ PE = - \\overline p. \\overline E $$",
            "$$\\ \\int E.dA = \\frac { \\sum q_i}{ \\epsilon_ \\circ} $$", "$$\\ E = \\frac { \\rho}{ \\epsilon_ \\circ} \\overline n $$", "$$\\ C = \\frac {Q}{V} $$", "$$\\ C = \\frac {k \\epsilon_ \\circ A}{d} $$",
            "$$\\ \\frac {1}{C} = \\frac {1}{C_1} + \\frac {1}{C_2} + \\frac {1}{C_3} + \\; .... + \\frac {1}{C_n} $$", "$$\\ C = C_1 + C_2 + C_3 + \\; ... \\; + C_n $$", "$$\\ W = \\frac {Q^2}{2C} = \\frac {CV^2}{2} = \\frac {QV}{2} $$"};

    String phyCurrElecNames[] = {"Eqn. of Balanced Wheatstone Network", "Eqn. of Meterbridge", "Eqn. of Potentiometer by Direct Method", "Eq. of Potentiometer by Sum & Difference Method",
                                 "Internal Resistance of Cell in a Potentiometer"};
    String phyCurrElec[] = {"$$\\ \\frac {R_1}{R_2} = \\frac {R_3}{R_4} $$", "$$\\ X = R( \\frac {l_x}{100 - l_x}) $$ $$\\ G = R( \\frac {l_g}{100 - l_g}) $$", "$$\\ \\frac {E_1}{E_2} = \\frac {l_1}{l_2} $$", "$$\\ \\frac {E_1}{E_2} = \\frac {L_1 + L_2}{L_1 - L_2} $$",
                            "$$\\ r = R(\\frac {l_1}{l_2} - 1) = R ( \\frac {E_1}{V} - 1) $$"};



    String phyHeatingEffNames[] = {"Heat Generated in a Conductor", "Electric Power", "Faraday's First Law of Electrolysis", "Faraday's Second Law of Electrolysis",
            "Faraday's Constant", "Neutral Temperature", "Thermoelectric Power", "Peltier Effect", "Thompson's Effect"};
    String phyHeatingEff[] = {"$$\\ H = i^2 Rt = Vit = \\frac {V^2t}{R} $$", "$$\\ P = i^2R = Vi = \\frac {V^2}{R} $$", "$$\\ m = Zit $$", "$$\\ \\frac {m_1}{m_2} = \\frac {E_1}{E_2} $$",
            "$$\\ F = \\frac {E}{Z} $$ $$\\ Or $$ $$\\ F = Ne $$", "$$\\ T_n = \\frac {T_i + T_ \\circ}{2} $$", "$$\\ S = \\frac {dE}{dT} = \\alpha + \\beta T $$", "$$\\ \\pi = \\frac {Peltier \\; Heat}{Charge \\; Flowing} $$", "$$\\ \\sigma = \\frac {dV}{dT} $$"};

    String phyMagEffNames[] = {"Biot Savart's Law", "Magnetic Field due to Straight Current Carrying Conductor", "Magnetic Field due to Infinite Length Wire", "Magnetic Dipole Moment",
            "Ampere Circuital Laws", "Soleniod", "Toroid", "Force on Charged Particle moving inside Magnetic Field",
            "Magnetic Force on Current Carrying Conductor in Uniform Magnetic Field", "Lorentz Force", "Cyclotron", "Force betw. two Infinitely Long Current Carrying Wires",
            "Torque on a Current Carrying Coil", "Moving Coil Galvanometer", "Galvanometer into an Ammeter", "Galvanometer in Voltmeter"};
    String phyMagEff[] = {"$$\\ dB = \\frac { \\mu_ \\circ}{4 \\pi} \\frac {I dl \\times r}{r^3} $$", "$$\\ B = \\frac { \\mu_ \\circ}{ 4 \\pi} \\frac {I}{r} \\; ( \\sin \\phi_1 + \\sin \\phi_2) $$", "$$\\ B = \\frac { \\mu_ \\circ I}{2 \\pi r} $$", "$$\\ |M| = NiA $$",
            "$$\\ \\int B. dl = \\mu_ \\circ I $$", "$$\\ At \\; a \\; Point \\; Inside \\; Solenoid $$ $$\\ B = \\mu_ \\circ In $$ $$\\ At \\; a \\; Point \\; on \\; One \\; End \\; of \\; Solenoid $$ $$\\ B = \\frac { \\mu_ \\circ In}{2} $$", "$$\\ At \\; Point \\; Inside \\; Toroid $$ $$\\ B = \\mu_ \\circ I n $$", "$$\\ F = q ( \\vec V \\times \\vec B) $$ $$\\ |F| = qV \\; B \\sin \\theta $$",
            "$$\\ F = I ( \\vec l \\times \\vec B) $$", "$$\\ F = q ( \\vec E + \\vec V \\times \\vec B) $$", "$$\\ E_{max} = \\frac {B^2 q^2 r_0 ^2}{2m} $$ $$\\ m = \\frac {m_ \\circ}{\\sqrt {1 - \\frac {v^2}{c^2}}} $$ $$\\ v = \\frac {Bq}{2 \\pi m} $$", "$$\\ F = \\frac { \\mu_ \\circ}{2 \\pi} \\frac {I_1 I_2}{r} per \\; unit \\; length $$",
            "$$\\ T = NBI A \\sin \\theta $$ $$\\ \\overline T = \\overline m \\times \\overline B $$", "$$\\ k \\theta = N B I A $$ $$\\ Current \\; Sensitivity $$ $$\\ I_S = \\frac { \\theta}{I} = \\frac {NBA}{k} $$ $$\\ Voltage \\; Sensitivity $$ $$\\ V_S = \\frac { \\theta}{V} = \\frac {NBA}{kR} $$", "$$\\ S = \\frac {I_g G}{I - I_g} $$", "$$\\ V = I_g (G + R) $$ $$\\ R = \\frac {V}{I_g} - G $$"};

    String phyMagnetismNames[] = {"Coulomb's Law of Magnetism", "Magnetic Dipole Moment", "Magnetic Field due to Magnetic Dipole on Axis", "Magnetic Field due to Magnetic Dipole on Equator",
            "Torque Acting on a Dipole in Uniform Magnetic Field", "Potential Energy of Magnetic Dipole", "Magnetic Dipole Moment of a Current Carrying Loop", "Gauss Law in Magnetism",
            "Magnetic Moment of an Atom", "Earth's Magnetism", "Magnetic Latitude", "Curie's Law"};
    String phyMagnetism[] = {"$$\\ F = \\frac { \\mu _\\circ}{4 \\pi} \\frac {m_1 m_2}{r^2} $$", "$$\\ M = m(2l) $$", "$$\\ \\vec B = \\frac { \\mu_ \\circ}{4 \\pi} \\frac {2 \\vec M r}{(r^2 - l^2)^2} $$ $$\\ If \\; r \\; >> \\; l $$ $$\\ \\vec B = \\frac { \\mu_ \\circ}{4 \\pi} \\frac {2 \\vec M}{r^3} $$", "$$\\ \\vec B = \\frac { \\mu_ \\circ}{4 \\pi} \\frac {- \\vec M}{(r^2 + l^2)^{3/2}} $$ $$\\ If \\; r >> l $$ $$\\ \\vec B = - \\frac {\\mu_ \\circ}{4 \\pi} \\frac { \\vec M}{r^3} $$",
            "$$\\ \\vec T = \\vec M \\times \\vec B $$ $$\\ |T| = MB \\sin \\theta $$", "$$\\ U = - \\vec M . \\vec B = -MB \\cos \\theta $$", "$$\\ \\vec M = NI \\vec A $$", "$$\\ \\int_S B. dS = 0 $$ $$\\ Magnetic \\; Flux \\; is \\; Zero $$",
            "$$\\ M = \\frac {1}{2} e \\omega r ^2 $$ $$\\ M = n \\frac {rh}{ 4 \\pi m} $$ $$\\ \\mu_B = \\frac {eh}{4 \\pi m} \\; (Bohr \\; Magneton) $$", "$$\\ H = B \\cos \\delta $$ $$\\ V = B \\sin \\delta $$", "$$\\ \\tan \\delta = 2 \\tan \\lambda $$ $$\\ I = I_ \\circ \\sqrt {1 + 3 \\sin^2 \\lambda} $$ $$\\ I_ \\circ = \\frac {M}{R^3} $$", "$$\\ X_m T = Constant $$"};

    String phyElecMagIndNames[] = {"Faraday's Law of EMI", "Magnetic Flux", "Lenz's Law", "Motional EMF",
            "Induced Current", "Coefficient of Self Induction", "Self Induction of Long Solenoid",
            "Self Inductance of a Toroid", "Energy Stored in an Inductor", "Coefficient of Mutual Inductance", "Coefficient of Coupling",
            "Mutual Inductance of Solenoids", "Grouping of Coils in Series", "Grouping of Coils in Parallel", "Eddy Current"};
    String phyElecMagInd[] = {"$$\\ E = - \\frac {d \\phi}{dt} $$", "$$\\ \\phi = N \\vec B. \\vec A $$", "$$\\ EMF \\; Generated \\; Opposes \\; Changes \\; in \\; Flux $$", "$$\\ E = Bvl $$ $$\\ E = \\frac {B \\omega l^2}{2} = BAf $$",
            "$$\\ I = \\frac {NBA \\omega \\sin \\omega t}{R} = I_ \\circ \\sin \\omega t $$", "$$\\ \\phi = LI $$ $$\\ E = -L \\frac {dI}{dt} $$", "$$\\ L = \\frac { \\mu_ \\circ N ^2 A}{l} = \\mu_ \\circ n^2 Al $$",
            "$$\\ L = \\frac { \\mu_ \\circ N^2 A}{2 \\pi r} $$", "$$\\ E = \\frac {1}{2}Li^2 $$", "$$\\ \\phi = MI $$ $$\\ E = -M \\frac {dI}{dt} $$", "$$\\ K = \\frac {M}{ \\sqrt{L_1 L_2}} $$",
            "$$\\ M = \\frac { \\mu_ \\circ N_1 N_2 A}{l} $$", "$$\\ L = L_1 + L_2 \\; \\; If \\; M = 0 $$ $$\\ L = L_1 + L_2 + 2M \\; (Same \\; Direction) $$ $$\\ L = L_1 + L_2 - 2M \\; (Opp. \\; Direction) $$", "$$\\ L = \\frac {L_1 L_2 - M^2}{L_1 + L_2 + 2M} \\; (Same \\; Direction) $$ $$\\ L = \\frac {L_1 L_2 - M^2}{L_1 + L_2 - 2M} \\; (Opp. \\; Direction) $$", "$$\\ Eddy's \\; Or \\; Facault's \\; Current $$ $$\\ i = - \\frac {e}{R} = \\frac {d \\phi / dt}{R} $$"};

    String phyAltCurrentNames[] = {"Displacement Current", "Maxwell's Equations", "Energy Density", "Energy Intensity", "Momentum of an Electromagnetic Wave"};
    String phyAltCurrent[]= {"$$\\ \\int \\vec B. \\vec {dl} = \\mu_ \\circ i + \\mu_ \\circ \\varepsilon_ \\circ ( \\frac {d \\phi_E}{dt}) $$ $$\\ i_d = \\varepsilon \\frac {d \\phi_E}{dt} $$ $$\\ or $$ $$\\ \\int \\vec B . \\vec{dl} =  \\mu_ \\circ (i + i_d) $$", "$$\\ \\int \\vec E . \\vec {dS} = \\frac {q_{enc}}{ \\varepsilon_ \\circ} $$ $$\\ \\int \\vec B . \\vec {dS} = 0 $$ $$\\ \\int \\vec E . \\vec {dl} = - \\frac {d \\phi_B}{dt} $$ $$\\ \\int \\vec B . \\vec {dl} = \\mu_ \\circ i + \\varepsilon_ \\circ \\mu_ \\circ \\frac {d \\phi_E}{dt} $$", "$$\\ u_{av} = \\frac {1}{2} \\varepsilon_ \\circ E^2 _ \\circ $$", "$$\\ I = \\frac {U}{A \\Delta t} = u_{av}c $$ $$\\ I = \\frac {1}{2} \\varepsilon_ \\circ E_ \\circ ^2 c $$", "$$\\ p = \\frac {U}{c} \\; (Completely \\; Absorbed) $$ $$\\ p = \\frac {2U}{c} \\; (Totally \\; Reflected) $$"};

    String phyRayOpticsNames[] = {"Laws of Reflection", "No. of Images", "Mirror Formula", "Linear Magnification",
            "Areal Magnification", "Laws of Refraction", "Relative Refractive Index", "Cauchy's Law",
            "Critical Angle", "Refraction at Spherical Surface", "Lens Formula", "Lens Maker's Formula",
            "Power of Lens", "Displacement Method", "Refractive Index of Prism", "Dispersion",
            "Camera", "Simple Microscope", "Compound Microscope", "Limit of Resolution"};
    String phyRayOptics[] = {"$$\\ \\angle i = \\angle r $$", "$$\\ n = \\lceil \\frac {360^ \\circ}{ \\theta} \\rceil $$", "$$\\ \\frac {1}{f} = \\frac {1}{v} + \\frac {1}{u} $$", "$$\\ m = \\frac IO = - \\frac vu $$",
            "$$\\ A. Mag = m^2 = \\frac {v^2}{u^2} $$", "$$\\ \\frac { \\sin (i)}{ \\sin (r)} = \\mu_ {21} $$", "$$\\ Refractive \\; Index = \\mu = \\frac {c}{v} $$ $$\\ Relative \\; R.I = \\mu_{21} = \\frac {v_2}{v_1} = \\frac {Height \\; of \\; Obj}{Height \\; of \\; Img.} $$", "$$\\ \\mu \\; \\alpha \\; \\frac {1}{ \\lambda^2} $$",
            "$$\\ \\sin C = \\frac {1}{ \\mu} $$", "$$\\ \\frac { \\mu}{v} - \\frac {1}{u} = \\frac { \\mu - 1}{R} $$", "$$\\ \\frac 1f = \\frac 1v - \\frac 1u $$", "$$\\ \\frac 1f = ( \\mu - 1) ( \\frac {1}{R_1} - \\frac {1}{R_2}) $$",
            "$$\\ P = \\frac {1}{f} $$", "$$\\ f = \\frac {a^2 - d^2}{4a} \\; | \\; O = \\sqrt {I_1 I_2} $$", "$$\\ \\mu = \\frac { \\sin ( \\frac {A + \\delta _m}{2})}{ \\sin ( \\frac {A}{2})} $$ $$\\ For \\; a \\; Small \\; Angle \\; Prism $$ $$\\ \\delta_m = ( \\mu - 1) A $$", "$$\\ Angular \\; Dispersion $$ $$\\ \\theta = \\delta_v - \\delta_R = ( \\mu_V - \\mu_R) A $$ $$\\ Dispersive \\; Power $$ $$\\ \\mu = \\frac { \\theta}{ \\delta_Y} = \\frac { \\mu_V - \\mu_R}{ \\mu_Y - 1} $$",
            "$$\\ Focal \\; No. = \\frac {Focal \\; Length \\; of \\; Lens}{Diameter \\; of \\; Lens} $$", "$$\\ M = 1 + \\frac {D}{f} $$ $$\\ Image \\; formed \\; at \\; Infinity $$ $$\\ M = \\frac {D}{f} $$", "$$\\ M = \\frac {v_o}{u_o} (1 + \\frac {D}{f_e}) $$ $$\\ Image \\; Formed \\; at \\; Infinity $$ $$\\ M = \\frac {v_o}{u_o} . \\frac {D}{f_e} $$", "$$\\ Resolving \\; Power \\; Of \\; Microscope $$ $$\\ \\frac {1}{d} = \\frac {2 \\mu \\sin \\theta}{ \\lambda} $$ $$\\ Resolving \\; Power \\; of \\; Telescope $$ $$\\ \\frac {1}{d \\theta} = \\frac {d}{1.22 \\; \\lambda} $$"};

    String phyWaveOpticsNames[]= {"Constructive Interference", "Destructive Interference", "Intensity & Amplitude of Resultant of Wave", "Frindge Width",
            "Shift in Frindge Pattern", "Fraunhofer Diffraction at a Single Slit"};
    String phyWaveOptics[] = {"$$\\ Phase \\; Difference $$ $$\\ \\phi = 2 n \\pi $$ $$\\ Path \\; Difference $$ $$\\ \\Delta x = n \\lambda $$", "$$\\ Phase \\; Difference $$ $$\\ \\phi = (2n - 1) \\pi $$ $$\\ Path \\; Difference $$ $$\\ \\Delta x = \\frac {(2n - 1) \\lambda }{2} $$", "$$\\ R = \\sqrt {a^2 + b^2 + 2 a cos \\phi} $$ $$\\ I = a^2 + b^2 + 2 a b \\cos \\phi $$ $$\\ \\frac {I_1}{I_2} = \\frac {a^2}{b^2} = \\frac { \\omega_1}{ \\omega_2} $$", "$$\\ \\beta = \\frac {D \\lambda}{d} $$ $$\\ x_n = \\frac {nD \\lambda}{d} $$ $$\\ x'_n = \\frac {(2n - 1)D \\lambda}{2_d} $$",
            "$$\\ Y = \\frac {D ( \\mu - 1) t}{d} = \\frac { \\beta ( \\mu - 1) t}{ \\lambda} $$", "$$\\ W = \\frac {2 D \\lambda}{a} = \\frac {2 f \\lambda}{a} $$ $$\\ \\omega = \\frac {2 \\lambda}{a} $$"};

    String phyDualNatureNames[] = {"Basic Formulas", "Photoelectric Effect", "Saturation Current", "Mass Energy Relation",
            "Momentum Wavelength Relation", "Heisenberb's Uncertainity Principle", "Mass Velocity Relation", "Radiation Pressure",
            "Wavelength and Voltage Relation for Electron", "Power at a Distance", "No. of Ejecting Photons"};
    String phyDualNature[] = {"$$\\ v \\lambda = c $$ $$\\ E = hv $$ $$\\ E = \\frac {hc}{ \\lambda} $$ $$\\ E (e V) = \\frac {12400}{ \\lambda (A^ \\circ)} $$", "$$\\ K.E_{(max)} = hv - hv_ \\circ \\; \\; hv_ \\circ = \\phi $$ $$\\ eV_ \\circ = KE_{(max)} = hv - \\phi $$", "$$\\ I_{(max)} = \\frac {1.6 \\times 10^{-19}. P . x}{hv}. A $$", "$$\\ E = mc^2 $$ $$\\ E = pc $$",
            "$$\\ E = \\frac {hc}{ \\lambda} $$ $$\\ E = pc $$ $$\\ \\lambda = \\frac {h}{p} $$", "$$\\ \\Delta x . \\Delta p \\ge \\frac {h}{4 \\pi} $$", "$$\\ m = \\frac {m_ \\circ}{ \\sqrt {1 - \\frac {v^2}{c^2}}} $$", "$$\\ I = Power / Area $$ $$\\ P_{radiation} = \\frac {I}{c} $$ $$\\ P_{radiation} = \\frac {2l}{c} $$",
            "$$\\ \\lambda = \\frac {1.22}{ \\sqrt {V}} $$", "$$\\ P_{(object)} = \\frac {P}{4 \\pi r^2}. A_{(object)} $$", "$$\\ No. \\; of \\; Photons \\; Ejecting = x. \\frac {P}{hv} $$"};

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////  CHEMISTRY
    //////////////////////////////////////////////////

    String chemBasicConceptsNames[] = {"Relation betw. Celsius & Fahrenheit", "Vapour Density of Gas", "Gram-Atom", "Number of Moles","Number of Molecules", "Application on Mole Concept", "No. of Gram Equivalent", "Equivalent Weight of an Element, Acid, Base, Ion & Compound",
            "Molarity", "Normality", "Strength", "Molality", "Mole Fraction", "Mass Fraction", "Avg. Atomic Mass of Atom", "Yield of Chemical Reaction", "Parts Per Million", "Relation betw. Molality & Molarity", "Relation betw. Molality & Mole frac.",
            "Relation betw. Molarity and Mole Fraction", "Relation betw. Normality & Molarity of the Soln.", "Molarity of Ion formed by Dissociation of a Compound", "Relation betw. Volume & Normality of a Solution", "Neutralisation"};
    String chemBasicConcepts[] = {"$$\\ ^ \\circ F = \\frac{9}{5}( ^ \\circ C) + 32 $$", "$$\\ v_d = \\frac{M_0}{2} $$", "$$\\ 1) No. of Gm. Atoms = \\frac{g}{A} $$ $$\\ 2) No. of Atoms = \\frac{g}{A} . N_o $$", "$$\\ n = \\frac{g}{M_o} $$",
            "$$\\ N = nN_o $$ ", "$$\\ mA + nB \\rightarrow pC + qD $$", "$$\\ Gm. Eq. = \\frac {g}{E} $$", "$$\\ E = \\frac {M_0}{x} $$",
            "$$\\ M = \\frac{n}{V} $$ $$\\ M = \\frac {S}{M_o} $$", "$$\\ N = \\frac{x.n}{V} $$ $$\\ N = \\frac {S}{E} $$ ", "$$\\ S = \\frac{w}{V} $$", "$$\\ m = \\frac{n}{w} $$",
            "$$\\ X_a = \\frac{n_a}{n_a + n_b} $$", "$$\\ m_A = \\frac{g_A}{g_A + g_A} $$", "$$\\ A_{avg} = \\frac{x1}{100} \\times A1 + \\frac{x2}{100} \\times A2 + ....  $$", "$$\\ Y = \\frac{Actual \\; Yield}{Theoretical \\; Yield} \\times 100 $$",
            "$$\\ PPM_A = \\frac{w_A}{W} \\times 10^6 $$", "$$\\ M = \\frac{md}{1 + mM_2/1000} $$", "$$\\ m = \\frac{1000 X_2}{X_1M_1} $$", "$$\\ M = \\frac{1000 dX_2}{X_1M_1 + X_2M_2} $$",
            "$$\\ N = M \\times \\frac{M_{ \\circ}}{E} $$", "in Uniform ", "$$\\ N_1V_1 = N_2V_2 $$ $$\\ M_1V_1 = M_2V_2 $$ $$\\ \\frac{M_1V_1}{n_1} = \\frac{M_2V_2}{n_2} $$", "$$\\ Gm.Eq \\; of \\; Acid = Gm.Eq \\; of \\; Base $$"};

    String chemStatesMatterNames[] = {"Volume", "Pressure", "Temperature", "Boyle's Law",
            "Charle's Law", "Gay Lussac's Law", "Avogadro's Law", "Contraction in Volume",
            "Ideal Gas Equation", "Dalton's Law", "Rate of Effusion", "Molecular Weight of Gas",
            "Root Mean Square Speed", "Avg. Speed of Gas Molecule", "Most Probable Speed", "Pressure Exerted by Gas",
            "Van der Waal's Eqn. of Gas", "Collision Frequency", "Mean Free Path", "Real Gas Equation",
            "Universal Eqn. of Gas", "Boyle's Temperature", "Critical Temperature of Gas", "Critical Pressure of Gas",
            "Critical Volume of Gas", "Viscosity of Liquids"};
    String chemStatesMatter[] = {"$$\\ 1 l = 10^3 ml = 10^{-3}m^3 = 10^3 cc $$", "$$\\ 1atm = 1.013 \\times 10^5 Pa $$ $$\\ 1bar = 10^5 N/m^2 $$", "$$\\ K = ^ \\circ C + 273.15 $$ $$\\ ^ \\circ F = \\frac {9}{5} ( ^ \\circ C) + 32 $$", "$$\\ PV = Const. $$",
            "$$\\ \\frac {V}{T} = Const. $$", "$$\\ \\frac {P}{T} = Const. $$", "$$\\ M_o = \\frac {g_A \\times 22.4}{V_L} $$", "$$\\ \\Delta V = V_R - V_P $$",
            "$$\\ PV = nRT $$ $$\\ PV = \\frac {g}{M_o} RT $$ $$\\ PM_o = dRT $$", "$$\\ p = xP_T $$", "$$\\ r = \\frac { \\Delta s}{ \\Delta t} $$ $$\\ r = \\frac { \\Delta n}{ \\Delta t} $$ $$\\ \\frac { \\Delta P}{ \\Delta t} $$", "$$\\ M = m_o N_o $$",
            "$$\\ C_{rms} = \\sqrt{c^2} = \\frac {3RT}{M_o} $$", "$$\\ C_{avg} = \\sqrt { \\frac {8RT}{ \\pi M_o}} $$", "$$\\ C_{MP} = \\frac {2RT}{M_o} $$", "$$\\ P = \\frac 13 \\rho c^2 _{rms} $$",
            "$$\\ (P + \\frac {a}{V^2 _m}) (V_m - b) = RT $$", "$$\\ z = \\frac { \\pi n^2 \\sigma^2 c_{avg}}{ \\sqrt{2}} $$", "$$\\ \\lambda = \\frac {1}{ \\sqrt{2} \\pi n \\sigma^2} $$", "$$\\ (P + \\frac {a n^2}{V^2}) (V - nb) = nRT $$",
            "$$\\ PV = ZnRT $$", "$$\\ T_B = \\frac {a}{Rb} $$", "$$\\ T_c = \\frac {8a}{27 R_b} $$", "$$\\ P_c = \\frac {a}{27 b^2} $$",
            "$$\\ V_mC = 3b $$", "$$\\ F = n A \\frac {dv}{dx} $$"};

    String chemAtomicStructNames[] = {"Radius of the Nucleus", "No. of Wave in nth Orbit", "Energy of Electron in nth Orbit", "Wave no. of Spectral Line",
            "Radius of nth Orbit of Atom", "Velocity of Electron in nth Orbit", "Energy of Photon", "Relation betw. Debroglie Wavelength & Momentum",
            "De-Broglie Wavelength of an Electron", "Mass of Particle moving with Velocity v", "Photoelectric Effect", "Heisenberg Uncertainity Principle",
            "Formulae to Calculate no. of Sub-shells & Electrons", "Total no. of Nodes", "Total no. of Radial Nodes", "Orbital Angular Momentum of an Electron"};
    String chemAtomicStruct[] = {"$$\\ r_o = (1.2 \\times 10^{-15} A^{1/3}) $$", "$$\\ N = \\frac {2 \\pi r}{ \\lambda} = n $$", "$$\\ E_n = - \\frac {2 \\pi^2 m_e K^2 _e Z^2 e^4}{n^2 h^2} $$ $$\\ where $$ $$\\ K = \\frac {1}{4 \\pi \\epsilon_o} $$", "$$\\ \\overline v = \\frac {1}{ \\lambda} = RZ^2 ( \\frac {1}{n^2} - \\frac {1}{m^2}) $$",
            "$$\\ r_n = \\frac {0.529 \\times n^2}{Z} \\; ^ \\circ A $$", "$$\\ V_n = \\frac {2.188 \\times 10^6 \\times Z}{n} m/s $$", "$$\\ E = hv $$ $$\\ E = \\frac {hc}{ \\lambda} $$ $$\\ E = \\frac {1240}{ \\lambda} eV $$", "$$\\ \\lambda = \\frac {h}{p} $$",
            "$$\\ \\lambda = \\frac {1.226 \\times 10^{-19}}{ \\sqrt{V}} $$", "$$\\ m = \\frac {m_{rest}}{\\sqrt {1 - (v/c)^2}} $$", "$$\\ hv = hv_o + K.E. $$", "$$\\ \\Delta x. \\Delta p \\ ge \\frac {h}{4 \\pi} $$ $$\\ \\Delta x . \\Delta v \\ge \\frac {h}{4 \\pi m} $$",
            "$$\\ No. \\; of \\; Sub-shells \\; in \\; nth \\; shell = n $$ $$\\ No. \\; of \\; Orbitals \\; in \\; nth \\; shell = n^2 $$ $$\\ No. \\; of \\; Orbitals \\; in \\; Subshell = 2l + 1 $$ $$\\ No. \\; of \\; Electrons \\; in \\; nth \\; shell = 2n^2 $$", "$$\\ N = n - 1 $$", "$$\\ N = n - l - 1 $$", "$$\\ L = \\sqrt {l (1 + 1)} . \\frac {h}{2 \\pi} $$"};

    String chemBondingNames[] = {"Formal Charge", "Bond Order", "Dipole Moment", "Hybridization"};
    String chemBonding[] = {"$$\\ FC = v_o - lp - \\frac {1}{2} s_e $$", "$$\\ BO = \\frac {N_b - N_a}{2} $$", "$$\\ \\mu = Q \\times r $$", "$$\\ Z = \\frac {1}{2} [v_e + m+a + c_n - c_p] $$"};

    String chemThermodyNames[] = {"First Law", "Work Done for Irreversible Expansion", "Work Done for Reversible Expansion", "Specific Heat Capacity",
            "Molar Heat Capacity", "Poisson's Ratio", "Enthalpy Change", "Enthalpy of Reaction",
            "Lavoisier Laplase Law", "Hess's Law", "Doulong & Petit Law", "Kirchoff's Equation",
            "Bond Dissociation Enthalpy", "Change in Entropy", "Entropy of Ideal Gas", "Entropy",
            "Joule Thompson Coefficient", "Inversion Temperature", "3rd Law of Thermodynamics"};
    String chemThermody[] = {"$$\\ q = -W + \\Delta U $$", "$$\\ W = -p_{ext} \\Delta V $$", "$$\\ W = -nRT \\; ln ( \\frac {V_2}{V_1}) $$", "$$\\ q = mc \\Delta T $$",
            "$$\\ At \\; Constant \\; Pressure $$ $$\\ C_p = c_p \\times M $$ $$\\ where $$ $$\\ c_p = ( \\gamma + 1) R $$ $$\\ At \\; Constant \\; Volume $$ $$\\ C_v = c_v \\times M $$ $$\\ where $$ $$\\ c_v = \\gamma R $$ $$\\ Relation $$ $$\\ c_p - c_v = R $$ $$\\ C_p - C_v = \\frac {R}{M} $$", "$$\\ \\gamma = \\frac {c_p}{c_v} = \\frac {C_p}{C_v} $$", "$$\\ \\Delta H = \\Delta U + \\Delta p \\Delta V $$ $$\\ \\Delta H = \\Delta U + \\Delta n_{(g)} RT $$", "$$\\ \\Delta_rH = \\sum H_{(p)} - \\sum H_{(R)} $$",
            "$$\\ A \\rightarrow B $$ $$\\ \\Delta_r H = H $$ $$\\  $$ $$\\ B \\rightarrow A $$ $$\\ \\Delta_r H = -H $$", "$$\\ \\Delta H = \\Delta H_1 + \\Delta H_2 + \\Delta H_3 $$", "$$\\ For \\; Metallic \\; Elements $$ $$\\ c \\times M = 6.4 cal/mol/ ^ \\circ C $$", "$$\\ \\Delta H_2 = \\Delta H_1 + \\Delta C_p (T_2 - T_1) $$",
            "$$\\ \\Delta H = \\sum H_R - \\sum H_P $$", "$$\\ \\Delta S = \\sum S_p - \\sum S_r = \\frac {q_{rev}}{T} = \\frac { \\Delta H}{T} $$", "$$\\ \\Delta S = nC_v ln( \\frac {T_2}{T_1}) + nR ln ( \\frac {V_2}{V_1}) $$", "$$\\ \\Delta S_m = \\frac { \\ Delta H_{fusion}}{T_m} $$ $$\\ \\Delta S_v = \\frac { \\Delta H_v}{T_b} $$ $$\\ \\Delta S_s = \\frac { \\Delta H_s}{T_s} $$",
            "$$\\ \\mu = \\frac {dT}{dP} $$", "$$\\ T_i = \\frac {2a}{Rb} $$", "$$\\ \\Delta S = \\int^T _0 C_p d \\; ln T $$"};

    String chemSolnsNames[] = {"Henry's Law", "Effect of Temperature on Solubility of Gases", "Relative Lowering of Vapour Pressure", "Osmotic Pressure",
            "Elevation in Boiling Point", "Depression in Freezing Point", "Calculating Molecular Mass from Vapour Pressure", "Calculating Molecular Mass from Boiling Point",
            "Calculating Molecular Mass from Freezing Point", "Equivalent Mass of an Element", "Equivalent Mass of an Acid, Base, Salt & Ion", "Equivalent Mass of Oxidizing & Reducing Agent"};
    String chemSolns[] = {"$$\\ P = k_H x $$", "$$\\ \\frac {c_2}{c_1} = \\frac { \\Delta}{R} ( \\frac {1}{T_1} - \\frac {1}{T_2}) $$", "$$\\ \\frac {p^ \\circ _A - p_A}{p^ \\circ _A} = X_A = \\frac {n_B}{n_A + n_B} $$", "$$\\ \\pi = CRT $$",
            "$$\\ \\Delta T_b = K_b ( \\frac {n_B}{g_A} \\times 1000) $$", "$$\\ \\Delta T_f = K_f ( \\frac {n_B}{g_A} \\times 1000) $$ ", "$$\\ M_B = \\frac {g_B M_A}{g_A} \\frac {P^o _A}{ \\Delta P} $$", "$$\\ M_B = K_b ( \\frac {g_B}{g_A \\Delta T_b} \\times 1000) $$",
            "$$\\ M_B = K_f ( \\frac {g_B}{g_A \\Delta T_f} \\times 1000) $$", "$$\\ E = \\frac {M}{x} $$", "$$\\ E = \\frac {M}{x} $$", "$$\\ E = \\frac {M}{x} $$"};

    String chemEquilNames[] = {"Equilibrium Constant", "Relation betw. Kp & Kc", "Eq. Constant when Reaction is Reversed",
            "Van't Hoff Equation", "Basics of Ionic Equilibrium", "Acidic Buffer Solution",
            "Basic Buffer Solution", "Buffer Capacity", "Solubility of Sparingly Soluble Salt"};
    String chemEquil[] = {"$$\\ mA + nB \\rightarrow pC + qD $$", "$$\\ aA + bB \\rightarrow xX + yY $$", "$$\\ mA + nB \\Leftrightarrow pC + qD, \\; k_{eq} = k_c $$",
            "$$\\ log \\frac {(k_p)_2} {(k_p)_1} = \\frac { \\Delta H}{2.303 \\; R} \\; ( \\frac {T_2 - T_1}{T_2 T_1})$$ $$\\ k_{eq} = \\frac {(K_p)_2}{(K_p)_1} $$", "$$\\ i) \\; pH + pOH = pK_w $$ $$\\ ii) \\; \\frac {S_1}{S_2} = \\sqrt { \\frac {k_1}{k_2}} $$ $$\\ iii) \\; pH = -log[H^+] $$ $$\\ iv) \\; k_a \\times k_b = k_w $$ $$\\ v) \\; k_w = 10^{-14} $$", "$$\\ pH = pK_a + log_{10} \\frac {[Salt]}{[Acid]} $$",
            "$$\\ pH = 14 - pK_b - log_{10} \\frac {Salt}{Base} $$", "$$\\ \\beta = \\frac { \\Delta n}{ \\Delta (pH)} $$ $$\\ \\beta_{max} = \\frac {C_{Buffer}}{4} $$", "$$\\ A_x B_y \\Leftrightarrow xA^{y+} + yB^{x+} $$"};

    String chemRedoxRxnNames[] = {"Oxidation", "Reduction", "Types of Redox Reactions", "Relation betw. Gibb's Free Energy & EMF of a Cell",
            "Faraday's First Law", "Faraday's Second Law", "Conductance", "Conductivity", "Molar Conductance"};
    String chemRedoxRxn[] = {"$$\\ A \\rightarrow A^{x+} + xe^{-} $$", "$$\\ A^{x+} + xe^{-} \\rightarrow A $$", "$$\\ Decomposition Reaction $$ $$\\ AB \\rightarrow A + B $$ $$\\ Combination Reaction $$ $$\\ A + B \\rightarrow C $$ $$\\ Displacement Reaction $$ $$\\ X + YZ \\rightarrow XZ + Y $$", "$$\\ - \\Delta G^o = n F E^o _{cell} $$",
            "$$\\ w = ZIt $$", "$$\\ w = \\frac {QE}{F} $$", "$$\\ G = \\frac {1}{R} $$", "$$\\ k = \\frac {l}{A} \\times G $$", "$$\\ C_{eq} = k \\times \\frac {1000}{N} $$"};

    String chemSurfaceNames[] = {"Freundlich's Adsorption Isotherm", "Adsorption from Solid"};
    String chemSurface[] = {"$$\\ \\frac {x}{m} = Kp^{ \\frac {1}{n}} \\; where \\; n > L $$ $$\\ log \\frac {x}{m} = log K + \\frac {1}{n} log \\; p $$", "$$\\ \\frac {x}{m} = k(C)^{ \\frac {1}{n}} $$ $$\\ log \\frac {x}{m} = log \\; K + \\frac {1}{n} log \\; C $$"};

    String chemClassElemNames[] = {"Atomic Volume"};
    String chemClassElem[] = {"$$\\ Atomic \\; Volume = \\frac {Molecular \\; Mass}{Density} $$"};

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////  MATHS
    //////////////////////////////////////////////////

    String mathSetsNames[] = {"Cardinal No. of a Finite Set", "Condition when Sets A & B are Equivalent", "Condition when Sets A& B are Disjoint", "No. of Elements in Power Set A",
            "Complement of Set A", "Symmetric Diff. of Two Sets", "No. of Elements in the Union of two Sets", "No. of Elements in Difference of two Sets", "No. of Elements in Union of Three Sets",
            "Idempotent Law", "Identity Law", "Commutative Law", "Associative Law", "Distributive Law", "De-Morgan's Law", "Other Laws on Algebra of Sets"};
    String mathSets[] = {"$$\\ n(A) = No. \\; of \\; Elements \\; of \\; set \\; A $$", "$$\\ n(A) = n(B) $$", "$$\\ A \\cap B = \\phi $$", "$$\\ n(P(A)) = 2^n $$",
            "$$\\ A' \\; or \\; A^c = U - A  $$", "$$\\ A \\Delta B = (A-B) \\cup (B-A) $$", "$$\\ n(A \\cup B) = n(A) + n(B) - n(A \\cap B) $$", "$$\\ n(A-B) = n(A) - n(A \\cap B) $$", "$$\\ n(A \\cup B \\cup C) = n(a) + n(B) + n(C) $$ $$\\ - n(A \\cap B) - n(A \\cap C) + n(A \\cap B \\cap C)$$",
            "$$\\ a) \\; A \\cup A = A $$  $$\\ b) \\; A \\cap A = A $$", "$$\\ a) A \\cup \\phi = A $$  $$\\ b) \\; A \\cap U = A $$", "$$\\ a) \\; A \\cup B = B \\cup A $$ $$\\ b) \\; A \\cap B = B \\cap A $$", "$$\\ a) \\; (A \\cup B) \\cup C = A \\cup ( B \\cup C ) $$  $$\\ b) \\; A \\cap (B \\cap C) = (A \\cap B) \\cap C $$", "$$\\ a) \\; A \\cup ( B \\cap C) = (A \\cup B) \\cap (A \\cup C) $$ $$\\ b) \\; A \\cap (B \\cup C) = (A \\cap B) \\cup (A \\cap C) $$",
            "$$\\ a) \\; (A \\cup B)' = A' \\cap B' $$ $$\\ b) \\; (A \\cap B)' = A' \\cup B' $$ $$\\ c) \\; A - (B \\cap C) = (A-B) \\cap (A-C) $$ $$\\ d) \\; A - (B \\cup C) = (A - B) \\cup (A - c) $$", "$$\\ a) \\; A - B = A \\cap B' $$ $$\\ b) \\; (A - B) \\cup B = A \\cup B $$ $$\\ c) \\; (A - B) \\cap B = \\phi $$ $$\\ d) \\; A \\cup (A \\cap B) = A $$ $$\\ e) \\; (A \\cap B) \\cup (A - B) = A $$ $$\\ f) \\; A \\subseteq B \\leftrightarrow B' \\subseteq A' $$"};

    String mathComplexNoNames[] = {"Integrals Power of Iota", "Addition of Complex No.s", "Subtraction of Complex No.s", "Multiplication of Complex No.s",
            "Division of Complex No.s", "Finding the Conjugate of Complex No.", "Finding the Modulus of Complex No.", "Multiplicative Inverse of a Complex No.",
            "Argument of a complex No.", "Complex No. in Polar Form", "De-Moivre's Theorem", "Finding the nth Root of Unity"};
    String mathComplexNo[] = {"$$\\ i^{4n+1} = i $$ $$\\ i^{4n+2} = -1 $$ $$\\ i^{4n+3} = -i $$ $$\\ i^{4n+1} = +1 $$", "$$\\ z_1 + z_2 = (x_1 + i y_1) + (x_2 + i y_2) $$  $$\\ = (x_1 + x_2) + i(y_1 + y_2) $$ $$\\  $$ $$\\ Properties: $$ $$\\ 1) \\; Commutative: \\; z_1 + z_2 = z_2 + z_1 $$ $$\\ 2) \\; Associative: \\; (z_1 + z_2) + z_3 = z_1 + (z_2 + z_3) $$ $$\\ 3) \\; Additive: \\; z + 0 = 0 + z  $$", "$$\\ z_1 - z_2 = (x_1 - x_2) + i (y_1 - y_2) $$", "$$\\ z_1 z_2 = (x_1 x_2 - y_1 y_2) + i(x_1 y_2 + x_2 y_1) $$ $$\\  $$ $$\\ Properties: $$ $$\\ 1) \\; Commutative: \\; z_1  z_2 = z_2  z_1 $$ $$\\ 2) \\; Associative: \\; (z_1 z_2) z_3 = z_1 (z_2 z_3) $$ $$\\ 3) \\; Multiplicative: \\; z.1 = 1.z $$",
            "$$\\ \\frac {z_1}{z_2} = \\frac {(x_1 x_2 + y_1 y_2) + i(x_2 y_1 - x_1 y_2)}{x^2 _2 + y^2 _2} $$", "$$\\ If: \\; z = x + iy $$ $$\\ Then: \\; \\vec z = x - iy $$", "$$\\ If: \\; z = x + iy $$ $$\\ Then: \\; |z| = \\sqrt {x^2 + y^2} $$", "$$\\ If: \\; z = x + iy $$ $$\\ Then : \\; z^{-1} = \\frac {x}{x^2 + y^2} + \\frac {i(-y)}{x^2 + y^2} $$",
            "$$\\ arg(z) = \\theta = \\tan ^{-1} \\frac {y}{x} $$", "$$\\ If: \\; z = x + iy $$ $$\\ Then: \\; z = |z| ( \\cos \\theta + i \\sin \\theta) $$", "$$\\ ( \\cos \\theta + i \\sin \\theta)^n = \\cos n \\theta + i \\sin n \\theta $$ $$\\ (e^{i \\theta})^n = e^{in \\theta} $$", "$$\\ If: \\; z^n = 1 $$ $$\\ z = \\cos \\frac {2 k \\pi}{n} + i \\sin \\frac {2 k \\pi}{n} $$ $$\\ where $$ $$\\ k = 0,1,2,3, ... (n-1) $$"};

    String mathQuadEqnNames[] = {"If One Root in Quadratic Eqn is k Times the Other Root", "Factorization Method", "Direct Formula", "In a Quadratic Equation",
            "Difference of Roots of Quadratic Equation", "Sum of Squares of Roots of Quadratic Equation", "Difference of Square of Root of Quadratic Equation", "Formation of Quadratic Equations"};
    String mathQuadEqn[] = {"$$\\ If: \\; ax^2 + bx + c = 0 $$ $$\\ Then: \\; \\frac {(k + 1)^2}{k} = \\frac {b^2}{ac} $$", "$$\\ ax^2 + bx + c = a (x - \\alpha)(x - \\beta) = 0 $$", "$$\\ ax^2 + bx + c = 0 $$ $$\\ \\alpha = \\frac {-b + \\sqrt {b^2 - 4 a c}}{2a} $$ $$\\ \\beta = \\frac {-b - \\sqrt {b^2 - 4 a c}}{2a} $$", "$$\\ ax^2 + bx + c = 0 \\; where \\; (a \\neq 0) $$ $$\\ S = \\frac {-b}{a} $$ $$\\ P = \\frac {c}{a} $$",
            "$$\\ ( \\alpha - \\beta) = \\frac { \\pm \\sqrt D}{a} $$", "$$\\ \\alpha ^2 + \\beta ^2 = \\frac {b^2 - 2ac}{a^2} $$", "$$\\ \\alpha ^2 - \\beta ^2 = \\frac { \\pm b \\sqrt D}{a^2} $$", "$$\\ x^2 + ( \\alpha + \\beta) x + \\alpha \\beta = 0 $$"};

    String mathMatricesNames[] = {"Addition & Subtraction of Matrices", "Properties of Addition of Matrices", "Multiplication of Matrices",
            "Transpose of Matrix", "Calculating Higher Power of Matrices", "Conjugate of Matrix"};
    String mathMatrices[] = {"$$\\ A = [a_{ij}]_{m \\times n}, \\; B = [b_{ij}]_{m \\times n} $$ $$\\ A + B = [a_{ij} + b_{ij}]_{m \\times n} $$ $$\\ A - B = [a_{ij} - b_{ij}]_{m \\times n} $$", "$$\\ 1) \\; Commutative \\; Law: \\; A + B = B + A $$ $$\\ 2) \\; Associative \\; Law: \\; (A + B) + C = A + (B + C) $$ $$\\ 3) \\; Cancellation \\; Law: \\; A + B = A + C \\rightarrow B = C $$", "$$\\ A = [a_{ij}]_{m \\times n}, \\; B = [b_{ij}]_{n \\times p} $$ $$\\ C = [c_{ij}]_{m \\times p} = AB $$",
            "$$\\ A = [a_{ij}]_{m \\times n} $$ $$\\ A' = A^T = [a_{ji}]_{n \\times m} $$", "$$\\ A^{n + 1} = A^n.A $$ $$\\ A^m . A^n = A^{m + n} $$", "$$\\ A = [a_{ij}]_{m \\times n} $$ $$\\ \\vec A = [ \\vec {a_{ij}}]_{m \\times n} $$"};

    String mathPerAndComNames[] = {"No. of Permutation of n Different Items", "No. of Permutation r Items Chosen from n Different Items", "No. of Permutations of n Items with p & q Identical Items", "Permutation if Repetition is Allowed",
            "n Different and r taken (Repetition is Allowed)", "Circular Permutation (Clockwise & Anticlockwise Different)", "Circular Permutation (Clockwise & Anticlockwise Same)", "No. of Combination choosing r Distinct Items from n Different Items",
            "Choosing r Items from n Different Items (Repetition Allowed)", "No. of Ways to Select One or More Objects", "De-arrangement Theorem", "Unequal Division",
            "Unequal Distribution", "Equal Division", "Equal Distribution", "Distribution Among Equal Groups"};
    String mathPerAndCom[] = {"$$\\ n! $$", "$$\\ ^n P _r = \\frac {n!}{(n - r) !} $$", "$$\\ \\frac {n!}{p! q!} $$", "$$\\ n^n $$",
            "$$\\ n^r $$", "$$\\ (n - 1)! $$", "$$\\ \\frac {(n - 1)!}{2} $$", "$$\\ ^n C _r = \\frac {n!}{(n - r)! . r!} $$",
            "$$\\ ^{n+r-1} C _r $$", "$$\\ 2^n - 1 $$", "$$\\ n! [1 - \\frac {1}{1!} + \\frac {1}{2!} - \\frac {1}{3!} + .... \\; (-1)^n \\frac {1}{n!}] $$", "$$\\ \\frac {(m + n + p)!}{m! n! p!} $$",
            "$$\\ \\frac {(m + n + p)!}{m! n! p!} \\times 3! $$", "$$\\ \\frac {(mn)!}{(n!)^m. m!} $$", "$$\\ \\frac {(mn)!}{(n!)^m} $$", "$$\\ \\frac {(m + 2n + 3p)}{m! (n!)^2 (p!)^3} $$"};

    String mathBinomialThoeNames[] = {"Binomial Expansion", "No. of Terms", "Equidistant Terms", "General Term",
            "Middle Term", "Middle Term", "Binomial Summition", "Sum of Square of Coefficients"};
    String mathBinomialThoe[] = {"$$\\ (x+y)^n = \\; ^nC_0 x^n + ^n C_1 x^{n-1}y + .... + ^n C_{n-1} x^1 y^{n-1} + ^n C_n y^n $$ $$\\ (x-y)^n = \\; ^nC_0 x^n - ^n C_1 x^{n-1} y + .... + (-1)^{n-1} \\; ^nC_n x^1 y^{n-1} + (-1)^n \\; ^nC_n y^n $$", "$$\\ No. \\; of \\; Terms \\; in \\; Expansion \\; of $$ $$\\ (x+y)^n = n+1 $$", "$$\\ ^n C_r = ^n C_{n-r} $$", "$$\\ T_{r+1} = ^n C_r x^{n-r} y^r $$",
            "$$\\ If \\; n \\; is \\; Even $$ $$\\ Middle \\; Term = ( \\frac {n}{2} + 1)^{th} \\; term $$", "$$\\ If \\; n \\; is \\; Odd $$ $$\\ Middle \\; Term = ( \\frac {n+1}{2}) \\; and \\; ( \\frac {n+3}{2}) $$", "$$\\ C_0 + C_1 + C_2 + C_3 + .... + C_n = 2^n $$", "$$\\ (C_0)^2 + (C_1)^2 + .... + (C_n)^2 = ^{2n} C_n $$"};

    String mathSeqSeriesNames[] = {"nth Term of an AP", "Common Difference of an AP", "Sum of n Terms on an AP", "Arithmetic Mean of n No.s",
            "Properties of Arithmetic Progression", "nth Term of GP", "nth Term of GP from end", "Common Ration of GP",
            "Geometric Mean of n Terms", "Sum of n Terms of GP", "Properties of Geometric Progression", "nth Term of HP",
            "Harmonic Mean of n Terms", "Relation between AM, GM and HM of Two No.s", "Sum of Infinite terms of Arithmetico Geometric Progression", "Sum of n Natural No.s", "Sum of Squares of n Natural No.s"};
    String mathSeqSeries[] = {"$$\\ a_n = a + (n-1)d $$", "$$\\ a' = a+k $$ $$\\ d' = d $$", "$$\\ S_n = \\frac {n}{2} [ 2a + (n-1)d] $$", "$$\\ A = \\frac { a_1 + a_2 + .... + a_n }{n} $$",
            "$$\\ 1) \\; a_n + a'_n = a+1 $$ $$\\ 2) \\; 2b = a+c $$ $$\\ 3) \\; T_n = S_n - S_{n-1} $$", "$$\\ a_n = ar^{n-1} $$", "$$\\ a'_n = \\frac {l}{r^{n-1}} $$", "$$\\ r' = r^n $$",
            "$$\\ GM = (a_1 a_2 a_3 .... a_n)^{1/n} $$", "$$\\ \\frac {a(1-r^n)}{1-r}, \\; if \\; |r| < 1 $$ $$\\ \\frac {a(r^n - 1)}{r-1}, \\; if \\; |r| > 1 $$ $$\\ an, \\; if \\; |r| = 1 $$", "$$\\ 1) \\; a_n a'_n = al $$ $$\\ 2) \\; c^2 = bd $$ $$\\ 3) \\; S_ \\infty = \\frac {a}{1-r} $$", "$$\\ a_n = \\frac {1}{a+ (n-1)d} $$",
            "$$\\ \\frac {1}{H} = \\frac {1}{n} ( \\frac {1}{a_1} + \\frac {1}{a_2} + .... + \\frac {1}{a_n}) $$", "$$\\ G^2 = AH $$", "$$\\ S_ \\infty = \\frac {a}{1-r} + \\frac {dr}{(1-r)^2} $$", "$$\\ S_n = \\frac {n(n+1)}{2} $$", "$$\\ S_n = \\frac {n(n+1)(2n+1)}{6} $$"};

    String mathStatisticsNames[] = {"Arithmetic Mean for Unclassified Data", "Arithmetic Mean for Frequency Distribution", "Arithmetic Mean for Classified Data", "Geometric Mean for Frequency Distribution",
            "Harmonic Mean for Frequency Distribution", "Median for Simple Distribution", "Median for Classified Data", "Mode for Classified Distribution",
            "Relation Between Mean, Median & Mode", "Mean Deviation for Simple Distribution", "Mean Deviation for Unclassified Distribution", "Mean Deviation for Classified Distribution",
            "Standard Deviation for Simple Distribution", "Standard Deviation for Unclassified Distribution", "Standard Deviation for Classified Data", "Co-effecient of Variance"};
    String mathStatistics[] = {"$$\\ x_{mean} = \\frac { \\sum x_i}{n} $$", "$$\\ A = \\frac { \\sum x_i f_i}{ \\sum f_i} $$", "$$\\ A = A_1 + (\\frac { \\sum f_i u_i}{ \\sum f_i}) h $$ $$\\ u_i = \\frac {x_i - A_i}{h} $$", "$$\\ G = (x_1 ^{f_1} x_2 ^{f_2} x_3 ^{f_3} .... x_n ^{f_n})^{1/N} $$",
            "$$\\ H = \\frac { \\sum^n _{i=1} f_i}{ \\sum^n _{i=1} \\frac {f_i}{x_i}} $$", "$$\\ If \\; n \\; is \\; Odd $$ $$\\ M = T_ \\frac {n+1}{2} $$ $$\\ If \\; n \\; is \\; Even $$ $$\\ M = \\frac {T_ \\frac {n}{2} + T_( \\frac {1}{n} + 1)}{2} $$", "$$\\ M_d = l + \\frac { \\frac {N}{2} - C}{f} \\times h $$", "$$\\ M_o = l + \\frac {f_0 - f_1}{2f_0 - f_1 - f_2} \\times h $$",
            "$$\\ M_o = 3M_d - 2M $$", "$$\\ \\delta = \\frac { \\sum |x - z|}{n} $$", "$$\\ \\delta = \\frac { \\sum f |x-z|}{ \\sum f} $$", "$$\\ \\delta = \\frac { \\sum f |x-z|}{ \\sum f} $$",
            "$$\\ \\sigma = \\sqrt { \\frac { \\sum (x - x_{mean})^2}{n}} $$", "$$\\ \\sigma = \\sqrt { \\frac { \\sum f (x - x_{mean})^2}{ \\sum f}} $$", "$$\\ \\sigma = \\sqrt { \\frac { \\sum f (x - x_{mean})^2}{ \\sum f}} $$", "$$\\ COV = \\frac { \\sigma }{x} \\times 100 $$"};

    String mathProbabilityNames[] = {"Chance of Occurrence of an Event", "Odds in Favour", "Odds Against Favour", "Mutually Exclusive Events",
            "Mutually Exhaustive Events", "Complimentary Events", "Probability of Both, A & B", "Conditional Probability",
            "Multiplication Theorem", "Baye's Theorem", "Mean of Binomial Distribution", "Poisson's Distribution"};
    String mathProbability[] = {"$$\\ P(A) = \\frac {n(A)}{n(S)} $$", "$$\\ \\frac {n}{m} $$", "$$\\ \\frac {m}{n} $$", "$$\\ P(A \\cap B) = 0 $$",
            "$$\\ P(A \\cup B) = 1 $$", "$$\\ P(A) + P(B) = 1 $$", "$$\\ P(A \\cap B) = \\frac {n(A \\cap B)}{n(S)} $$", "$$\\ P(A/B) = \\frac {P(A \\cap B)}{P(B)} $$",
            "$$\\ P(A \\cap B) = P(B) P(A/B) = P(A) P(B/A) $$", "$$\\ P(A_k / E) = \\frac {P(A_k) P (E/A_k)}{ \\sum^n _{i=1} P(A_i) P(E/A_i)} $$", "$$\\ \\mu = np $$", "$$\\ P(X = r) = e^{ \\lambda}. \\frac { \\lambda ^r}{r!} $$ $$\\ where \\; \\lambda = np $$"};

    String mathDiffCalculusNames[] = {"Left Hand Limit at x = a", "Right Hand Limit at x = a", "Condition for existance of a Limit at x = a", "Multiplication of Constant with Limit",
            "Multiplication of Two Limits", "Fraction of Two Limits", "Limit of an Exponential ", "Modulus of a Limit",
            "Limit by Factorisation", "Limit by Substitution", "Algebraic Expansion", "Continuity at a Point"};
    String mathDiffCalculus[] = {"$$\\ f(a-0) = \\lim \\limits_{x \\to a^-} f(x) = \\lim \\limits_{h \\to 0} f(a-h)$$", "$$\\ f(a+0) = \\lim \\limits_{x \\to a^+} f(x) = \\lim \\limits_{h \\to 0} f(a+h)$$", "$$\\ \\lim \\limits_{x \\to a^-} f(x) = \\lim \\limits_{x \\to x^+} f(x) $$", "$$\\ \\lim \\limits_{x \\to a} [kf(x)] = k \\lim \\limits_{x \\to a} f(x) $$",
            "$$\\ \\lim \\limits_{x \\to a} [f(x) g(x)] = \\lim \\limits_{x \\to a} fx \\; \\lim \\limits_{x \\to g(x)} $$", "$$\\ \\lim \\limits_{x \\to a} \\frac {f(x)}{g(x)} = \\frac { \\lim \\limits_{x \\to a} f(x)}{ \\lim \\limits_{x \\to a} g(x)} $$ $$\\ \\lim \\limits_{x \\to a} g(x) \\neq 0 $$", "$$\\ \\lim \\limits_{x \\to a} e^{f(x)} = e^{ \\lim \\limits_{x \\to a} f(x)} $$", "$$\\ \\lim \\limits_{x \\to a} |f(x)| = | \\lim \\limits_{x \\to a} f(x)| $$",
            "$$\\ \\lim \\limits_{x \\to a} \\frac {x^n - a^n}{x-a} = na^{n-1} $$", "$$\\ \\lim \\limits_{x \\to a} f(x) = \\lim \\limits_{h \\to 0} f(a \\pm h) $$", "$$\\ (1+x)^n = 1 + ^nC_1 x + ^n C_2 x + .... + ^n C_n x^n $$", "$$\\ \\lim \\limits_{x \\to a^-} f(x) = \\lim \\limits_{x \\to a^+} f(x) = f(a) $$"};

    String mathStLinesNames[] = {"Quadrants", "Polar Co-ordinates", "Distance Formula in Cartesian Form", "Distance Formula if Polar Forms",
            "Internal Division", "External Division", "Mid Point of a Line Segment", "Centroid of a Triangle",
            "Circum-centre of a Triangle", "Incentre of a Triangle", "Shifting of Origin", "Rotation of Axes",
            "Slope of Line", "Angle between Two Lines", "Slope Intercept Form", "One Point Form",
            "Two Point Form", "Intercept Form", "General Equation of a Straight Line", "Normal Form",
            "Point of Intersection of Two Lines"};
    String mathStLines[] = {"$$\\ First \\; Quadrant $$ $$\\ x > 0 , \\; y > 0 $$ $$\\ Second \\; Quadrant $$ $$\\ x < 0, \\; y > 0 $$ $$\\ Third \\; Quadrant $$ $$\\ x < 0, \\; y < 0 $$ $$\\ Fourth \\; Quadrant $$ $$\\ x > 0, \\; y < 0 $$", "$$\\ x = r \\cos \\theta $$ $$\\ y = r \\sin \\theta $$ $$\\ r = \\sqrt{x^2 + y^2} $$", "$$\\ PQ = \\sqrt{(x_2 - x_1)^2 (y_2 - y_1)^2} $$", "$$\\ PQ = \\sqrt{r^2 _1 + r^2 _2 - 2r_1 r_2 \\cos ( \\theta_1 - \\theta_2)} $$",
            "$$\\ (x,y) = ( \\frac {m_1 x_2 + m_2 x_1}{m_1 + m_2}, \\frac {m_1y_2 + m_2 y_1}{m_1 + m_2}) $$", "$$\\ (x,y) = ( \\frac {m_1 x_2 - m_2 x_1}{m_1 - m_2}, \\frac {m_1 y_2 - m_2 y_1}{m_1 - m_2}) $$", "$$\\ (x,y) = ( \\frac {x_1 + x_2}{2}, \\frac {y_1 + y_2}{2}) $$", "$$\\ (x,y) = ( \\frac {x_1 + x_2 + x_3}{3} , \\frac {y_1 + y_2 + y_3}{3}) $$",
            "$$\\ x = ( \\frac {x_1 \\sin 2A + x_2 \\sin 2B + x_3 \\sin 2C}{ \\sin 2A + \\sin 2B + \\sin 2C}) $$ $$\\ y = ( \\frac {y_1 \\sin 2A + y_2 \\sin 2B + y_3 \\sin 2C}{ \\sin 2A + \\sin 2B + \\sin 2C}) $$", "$$\\ (x,y) = ( \\frac {ax_1 + bx_2 + cx_3}{a + b + c}, \\frac {ay_1 + by_2 + cy_3}{a + b + c}) $$", "$$\\ x = X + h, \\; y = Y + k $$", "$$\\ X = x \\cos \\theta + y \\sin \\theta $$ $$\\ Y = y \\cos \\theta + x \\sin \\theta $$",
            "$$\\ m = \\tan \\theta = \\frac {y_2 - y_1}{x_2 - x_1} $$", "$$\\ \\tan \\theta = |\\frac {m_2 - m_1}{1 + m_1 m_2}| $$", "$$\\ y = mx + c $$", "$$\\ (y - y_)1 = m(x - x_1)) $$",
            "$$\\ (y - y_1) = ( \\frac {y_2 - y_1}{x_2 - x_1}) (x - x_1) $$", "$$\\ \\frac {x}{a} + \\frac {y}{b} = 1 $$", "$$\\ Ax + By + C = 0 $$", "$$\\ x \\cos \\theta \\alpha + y \\sin \\theta \\alpha = p $$",
            "$$\\ (x,y) = ( \\frac {b_1 c_2 - c_2 b_1}{a_1 b_2 - a_2 b_1}, \\frac {c_1 a_2 - c_2 a_1}{a_1 b_2 - a_2 b_1}) $$"};

    String mathCirclesNames[] = {"Equation of a Circle Having Centre (h,k) & Radius a", "Equation of Circle Passing through Origin", "Equation of a Circle Touching X-axis", "Equation of a Circle Touching Y-axis",
            "Equation of a Circle Touching Both Axis", "Equation of a Circle Passing Through Origin and Centre Lying on the X-axis", "Equation of Circle Passing throuogh Origin and Centre Lying on the Y-axis", "Eqn. of Circle Passing through Origin and Cutting Intercept a & b on the Co-ordinate Axis",
            "Eqn. of a Circle Passing through End Points of Diameter", "Parametric Eqn. of a Circle", "Angle Between Two Circles", "Equation of the Radial Axis of Two Circles", "Length of Common Chord"};
    String mathCircles[] = {"$$\\ (x-h)^2 + (y-k)^2 = a^2 $$", "$$\\ x^2 + y^2 - 2hx - 2ky = 0 $$", "$$\\ x^2 + y^2 - 2hx -2ky + h^2 = 0 $$", "$$\\ x^2 + y^2 - 2hx - 2ky + k^2 = 0 $$",
            "$$\\ x^2 + y^2 - 2ax - 2ay + a^2 = 0 $$", "$$\\ x^2 + y^2 - 2ax = 0 $$", "$$\\ x^2 + y^2 -2ay = 0 $$", "$$\\ x^2 + y^2 - by = 0 $$",
            "$$\\ (x - x_1)(x - x_2) + (y - y_1)(y - y_2) = 0 $$", "$$\\ x = h + a \\cos \\theta $$ $$\\ y = k + a \\sin \\theta $$ $$\\ \\theta \\; lies \\; from \\; 0 \\; to \\; 2 \\pi $$", "$$\\ \\cos \\theta = \\frac {r^2 _1 + r^2 _2 - d^2}{2 r_1 r_2} $$", "$$\\ S_1 - S_2 = 0 $$", "$$\\ l = 2 \\sqrt{(d_1)^2 - (d_2)^2} $$"};

    String mathTrigonoNames[] = {"Sine of Sum of Angles", "Sine of Difference of Angles", "Cos of Sum of Angles", "Cos of Difference of Angles",
            "Tan of Sum of Angles", "Tan of Difference of Angles", "Cot of Sum of Angles", "Cot of Difference of Angles",
            "Tan of Sum of Three Angles", "Cot of Sum of Three Angles", "Sine of Sum of Three Angles", "Cos of Sum of Three Angles",
            "Product of Sine of Sum & Difference", "Sine of Twice of Angle", "Cos of Twice of Angles", "Tan of Twice of Angles",
            "Sine of Thrice of Angles", "Cos of Thrice of Angles", "Tan of Thrice of Angles", "Product of Two Sines",
            "Product of Two Cosines", "Product of Sine & Cosine", "Sum of Two Sines", "Difference of Two Sines",
            "Sum of Two Cosines", "Difference of Two Cosines"};
    String mathTrigono[] = {"$$\\ \\sin (A + B) = \\sin A \\cos B + \\cos A \\sin B $$", "$$\\ \\sin (A - B) = \\sin A \\cos B - \\cos A \\sin B $$", "$$\\ \\cos (A + B) = \\cos A \\cos B - \\sin A \\sin B $$", "$$\\ \\cos (A - B) = \\cos A \\cos B + \\sin A \\sin B $$",
            "$$\\ \\tan (A + B) = \\frac { \\tan A + \\tan B}{1 - \\tan A \\tan B} $$", "$$\\ \\tan (A - B) = \\frac { \\tan A - \\tan B}{1 + \\tan A \\tan B} $$", "$$\\ \\cot (A + B) = \\frac { \\cot A \\cot B - 1}{ \\cot A + \\cot B} $$", "$$\\ \\cot (A - B) = \\frac { \\cot A \\cot B + 1}{ \\cot B - \\cot A} $$",
            "$$\\ \\tan (A + B + C) = \\frac { \\tan A + \\tan B + \\tan C - \\tan A \\tan B \\tan C}{1 - \\tan A \\tan B - \\tan B \\tan C - \\tan A \\tan C} $$", "$$\\ \\cot (A + B + C) = \\frac {\\cot A + \\cot B + \\cot C - \\cot A \\cot B \\cot C}{1 - \\cot A \\cot B - \\cot B \\cot C - \\cot A \\cot C} $$", "$$\\ \\sin (A + B + C) = \\sin A \\cos B \\cos C + \\cos A \\sin B \\cos C $$ $$\\ - \\sin A \\sin B \\sin C $$", "$$\\ \\cos (A + B + C) = \\cos A \\cos B \\cos C - \\sin A \\sin B \\cos C - \\sin A \\cos B \\sin C $$ $$\\ - \\cos A \\sin B \\sin C $$",
            "$$\\ \\sin (A - B) \\sin (A + B) = \\sin ^2 A - \\sin ^2 B = \\cos ^2 B - \\cos ^2 A $$", "$$\\ \\sin 2A = 2 \\sin A \\cos A = \\frac {2 \\tan A}{1 + \\tan ^2 A} $$", "$$\\ \\cos 2A = \\cos ^2 A - \\sin ^2 A = \\frac {1 - \\tan ^2 A}{1 + \\tan ^2 A} $$", "$$\\ \\tan 2A = \\frac {2 \\tan A}{1 - \\tan ^2 A} $$",
            "$$\\ \\sin 3A = 3 \\sin A - 4 \\sin ^2 A $$", "$$\\ \\cos 3A = 4 \\cos ^2 A - 3 \\cos A $$", "$$\\ \\tan 3A = \\frac {3 \\tan A - \\tan ^2 A}{1 - 3 \\tan ^2 A} $$", "$$\\ 2 \\sin A \\sin B = \\cos (A - B) - \\cos (A + B) $$",
            "$$\\ 2 \\cos A \\cos B = \\cos (A + B) + \\cos (A - B) $$", "$$\\ 2 \\sin A \\cos B = \\sin (A + B) + \\sin (A - B) $$", "$$\\ \\sin A + \\sin B = 2 \\sin \\frac {A + B}{2} \\cos \\frac {A + B}{2} $$", "$$\\ \\sin A - \\sin B = 2 \\sin \\frac {A - B}{2} \\cos \\frac {A + B}{2} $$",
            "$$\\ \\cos A + \\cos B = 2 \\cos \\frac {A + B}{2} \\cos \\frac {A - B}{2} $$", "$$\\ \\cos A - \\cos B = -2 \\sin \\frac {A + B}{2} \\sin \\frac {A - B}{2} $$"};

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////  GENERAL
    //////////////////////////////////////////////////

    String genExpFormNames[] = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    String genExpForm[] = {"$$\\ (a + b)^2 = a^2 + 2ab + b^2 $$", "$$\\ (a - b)^2 = a^2 - 2ab + b^2 $$", "$$\\ a^2 + b^2 = (a+b)^2 - 2ab $$", "$$\\ a^2 + b^2 = (a-b)^2 + 2ab $$",
            "$$\\ a^2 - b^2 = (a + b)(a-b) $$" ,"$$\\ ab = ( \\frac {a + b}{2})^2 - ( \\frac {a-b}{2})^2 $$", "$$\\ a^3 - b^3 = (a-b)(a^2 + ab + b^2) $$", "$$\\ a^3 + b^3 = (a+b)(a^2 - ab + b^2) $$",
            "$$\\ (a+b)^2 + (a - b)^2 = 2 (a^2 + b^2) $$", "$$\\ (a+b)^3 = a^3 + b^3 + 3ab(a+b) $$", "$$\\ (a-b)^3 = a^3 - b^3 - 3ab(a-b) $$"};

    String genQuadEqnNames[] = {"Finding First Term", "Finding Second Term", "Finding Third Term"};
    String genQuadEqn[] = {"$$\\ First \\; Term = ( \\frac {Second \\; Term}{2 \\times \\sqrt{Third \\; Term}})^2 $$", "$$\\ Third \\; Term = ( \\frac {Second \\; Term}{2 \\times \\sqrt{ First \\; Term}})^2 $$", " $$\\ Second \\; Term = 2 \\times \\sqrt {First \\; Term} \\times \\sqrt {Third \\; Term} $$"};

    String genDivAlgNames[] = {"Dividend", "Divisor", "Quotient", "Remainder"};
    String genDivAlg[] = {"$$\\ Divisor \\times Quotient + Remainder $$", "$$\\ \\frac {Dividend - Remainder}{Quotient} $$", "$$\\ Quotient = \\frac {Dividend - Remainder}{Divisor} $$", "$$\\ Remainder = Dividend - (Divisor \\times Quotient) $$"};

    String genIndLawsNames[] = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    String genIndLaws[] = {"$$\\ a^m \\times a^n = a^{m+n} $$", "$$\\ a^m / a^n = a^{m-n} $$", "$$\\ (a^m)^n = a^{mn} $$", "$$\\ (ab)^n = a^n b^n $$",
            "$$\\ \\frac {1}{a^n} = a^{-n} $$", "$$\\ ( \\frac {a}{b})^n = a^n / b^n $$", "$$\\ \\frac {1}{a^2} = a^{-2} $$", "$$\\ a^0 = 1 $$",
            "$$\\ a^1 = a $$", "$$\\ a^{p/q} = (a^p)^{1/q} $$"};

    String genRatioPropNames[] = {"Invertendo", "Alternendo", "Componendo", "Dividendo",
            "Componendo & Dividendo", "k Method"};
    String genRatioProp[] = {"$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac ba = \\frac dc $$", "$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac ac = \\frac bd $$", "$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac {a+b}{c} = \\frac {c+d}{d} $$", "$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac {a-b}{b} = \\frac {c-d}{d} $$",
            "$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac {a+b}{a-b} = \\frac {c+d}{c-d} $$", "$$\\ If \\; \\frac {a}{b} = \\frac {c}{d} $$ $$\\ Then \\; \\frac ab = \\frac cd = k $$ $$\\ a = bk \\; and \\; c = dk $$"};

    String genSurfMesNames[] = {"Acre", "Dismil", "Are", "Hectare"};
    String genSurfMes[] = {"$$\\ 1 \\; Acre = 100 \\; Dismils $$ $$\\ 1 \\; Acre = 4000 \\; Sq. \\; Metres $$", "$$\\ 1 \\; Dismil = 436 \\; Sq. \\; Feets $$ $$\\ 1 \\; Dismil = 40 \\; Sq. \\; Metres $$", "$$\\ 1 \\; Are = 100 \\; Sq. \\; Metres $$", "$$\\ 1 \\; Hectare = 250 \\; Dismil \\; = \\; 2.5 \\; Acres $$ $$\\ 1 \\; Hectare = 10000 \\; Sq. \\; Metres $$"};

    String genConvNames[] = {"Units of Length", "Units of Weight", "Units of Time",
            "Units of Counting", "Units of Temperature"};
    String genConv[] = {"$$\\ 1 \\; Kilometre = 1000 \\; Metre = 0.621 \\; Mile $$ $$\\ 1 \\; Mile = 1.609 \\; Kilometers $$ $$\\ 1 \\; Metre = 100 \\; Centimetre = 3.28 \\; Feet $$ $$\\ 1 \\; Foot = 12 \\; Inches $$ $$\\ 1 \\; Inch = 2.54 \\; Centimetres $$ $$\\ 1 \\; Centimetre = 10 \\; Millimetre $$ $$\\ 1 \\; Yard = 3 \\; Feet $$ $$\\ 1 \\; Mile = 1760 \\; Yards $$ $$\\ 1 \\; Furlong = 220 \\; Yards $$",
            "$$\\ 1 \\; Kilogram = 1000 \\; Grams $$ $$\\ 1 \\; Quintal = 100 \\; Kg $$ $$\\ 1 \\; Ton = 10 \\; Quintals \\; = \\; 1000 \\; Kg $$ $$\\ 1 \\; Pound = 455 \\; Grams $$ $$\\ 1 \\; Kilogram = 2.2 \\; Pounds $$ $$\\ 1 \\; Litre = 4.5 \\; Litres $$ $$\\ 1 \\; Tola = 12 \\; Grams $$",
            "$$\\ 1 \\; Hour = 60 \\; Minutes $$ $$\\ 1 \\; Minute = 60 \\; Seconds $$ $$\\ 1 \\; Hour = 3600 \\; Seconds $$ $$\\ 1 \\; Day = 1440 \\; Minutes \\; = \\; 86400 \\; Seconds $$ $$\\ 1 \\; Week = 7 \\; Days $$ $$\\ 1 \\; Month = 30 \\; Days $$ $$\\ 1 \\; Year = 12 \\; Months \\; = \\; 365 \\; Days $$ $$\\ 1 \\; Leap \\; Year = 366 \\; Days $$ $$\\ 1 \\; Decade = 10 \\; Years $$ $$\\ 1 \\; Century = 100 \\; Years $$ $$\\ 1 \\; Milliennium = 1000 \\; Years $$",
            "$$\\ 1 \\; Dozen = 12 \\; Units $$ $$\\ 1 \\; Quire = 24 \\; Sheets $$ $$\\ 1 \\; Short \\; Ream = 480 \\; Sheets $$ $$\\ 1 \\; Long \\; Ream = 500 \\; Sheets $$ $$\\ 1 \\; Gross = 12 \\; Dozen \\; = \\; 144 \\; Sheets $$",
            "$$\\ ^ \\circ F = ( \\frac {9^ \\circ C}{5}) + 32 $$ $$\\ ^ \\circ C = \\frac {5 ( ^ \\circ F - 32)}{9} $$ $$\\ 0^{ \\circ} = 32^{ \\circ} F = 273^{ \\circ} K $$"};

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////  Formula Address
    //////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);

        FormAdView = (AdView) findViewById(R.id.formulaAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        FormAdView.loadAd(adRequest);

        chapterName = (TextView) findViewById(R.id.formulaText);
        formulaView = (MathView) findViewById(R.id.MathView);

        //Toast.makeText(Formulas.this, "Click on the Ad to Unlock All the Formulas for Free", Toast.LENGTH_LONG).show();

        Bundle bundle = getIntent().getExtras();
        String formulaText = bundle.getString("formula");

        //////////////////////////////////////////////////
        //////////////////////////////////////////////////  PHYSICS
        //////////////////////////////////////////////////

        if(formulaText.equals("Kinematics")){
            chapterName.setText("Kinematics");
            formulaSize = 12;
            formulaNames = phyKinematsName;
            formulas = phyKinemats;
            formulaView();
            showInterstitialAd();

        }

        if(formulaText.equals("Laws of Motion")){
            chapterName.setText("Laws of Motion");
            formulaSize = 7;
            formulaNames = phyLawsOfMotionNames;
            formulas = phyLawsOfMotion;
            formulaView();
        }

        if(formulaText.equals("Work Power Energy")){
            chapterName.setText("Work Power Energy");
            formulaSize = 10;
            formulaNames = phyWPENames;
            formulas = phyWPE;
            formulaView();
        }

        if(formulaText.equals("Rotational Motion")){
            chapterName.setText("Rotational Motion");
            formulaSize = 12;
            formulaNames = phyRMotionNames;
            formulas = phyRMotion;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Gravitation")){
            chapterName.setText("Gravitation");
            formulaSize = 13;
            formulaNames = phyGravitationNames;
            formulas = phyGravitation;
            formulaView();
        }

        if(formulaText.equals("Thermodynamics")){
            chapterName.setText("Thermodynamics");
            formulaSize = 11;
            formulaNames = phyThermoNames;
            formulas = phyThermo;
            formulaView();
        }

        if(formulaText.equals("Kinetic Theory of Gases")){
            chapterName.setText("Kinetic Theory of Gases");
            formulaSize = 10;
            formulaNames = phyKinTheoryNames;
            formulas = phyKinTheory;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Properties of Matters")){
            chapterName.setText("Properties of Matters");
            formulaSize = 26;
            formulaNames = phyPropMatterNames;
            formulas = phyPropMatter;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Oscillations")){
            chapterName.setText("Oscillations");
            formulaSize = 16;
            formulaNames = phyOscillsNames;
            formulas = phyOscills;
            formulaView();
        }

        if(formulaText.equals("Elasticity")){
            chapterName.setText("Elasticity");
            formulaSize = 7;
            formulaNames = phyElastNames;
            formulas = phyElast;
            formulaView();
        }

        if(formulaText.equals("Waves and Sound")){
            chapterName.setText("Waves and Sound");
            formulaSize = 9;
            formulaNames = phyWavesNames;
            formulas = phyWaves;
            formulaView();
        }

        if(formulaText.equals("Circular Motion")){
            chapterName.setText("Circular Motion");
            formulaSize = 9;
            formulaNames = phyCircMotNames;
            formulas = phyCircMot;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Electrostatics")){
            chapterName.setText("Electrostatics");
            formulaSize = 15;
            formulaNames = phyElectrostaticsNames;
            formulas = phyElectrostatics;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Current & Electricity")){
            chapterName.setText("Current & Electricity");
            formulaSize = 5;
            formulaNames = phyCurrElecNames;
            formulas = phyCurrElec;
            showInterstitialAd();
            formulaView();
        }

        if(formulaText.equals("Heating Eff. of Current")){
            chapterName.setText("Heating Eff. of Current");
            formulaSize = 9;
            formulaNames = phyHeatingEffNames;
            formulas = phyHeatingEff;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Magnetic Eff. of Current")){
            chapterName.setText("Magnetic Eff. of Current");
            formulaSize = 16;
            formulaNames = phyMagEffNames;
            formulas = phyMagEff;
            formulaView();
        }

        if(formulaText.equals("Magnetism")){
            chapterName.setText("Magnetism");
            formulaSize = 12;
            formulaNames = phyMagnetismNames;
            formulas = phyMagnetism;
            formulaView();
        }

        if(formulaText.equals("Electromagnetic Induction")){
            chapterName.setText("Electromagnetic Induction");
            formulaSize = 15;
            formulaNames = phyElecMagIndNames;
            formulas = phyElecMagInd;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Alternating Current")){
            chapterName.setText("Alternating Current");
            formulaSize = 5;
            formulaNames = phyAltCurrentNames;
            formulas = phyAltCurrent;
            formulaView();
        }

        if(formulaText.equals("Ray Optics")){
            chapterName.setText("Ray Optics");
            formulaSize = 20;
            formulaNames = phyRayOpticsNames;
            formulas = phyRayOptics;
            formulaView();
        }

        if(formulaText.equals("Wave Optics")){
            chapterName.setText("Wave Optics");
            formulaSize = 6;
            formulaNames = phyWaveOpticsNames;
            formulas = phyWaveOptics;
            formulaView();
        }

        if(formulaText.equals("Dual Nature of Matter")){
            chapterName.setText("Dual Nature of Matter");
            formulaSize = 11;
            formulaNames = phyDualNatureNames;
            formulas = phyDualNature;
            formulaView();
            showInterstitialAd();
        }

        ///////////////////////////////////////////////////
        /////////////////////////////////////////////////// CHEMISTRY
        ///////////////////////////////////////////////////

        if(formulaText.equals("Basic Concepts in Chemistry")){
            chapterName.setText("Basic Concepts in Chemistry");
            formulaSize = 24;
            formulaNames = chemBasicConceptsNames;
            formulas = chemBasicConcepts;
            formulaView();
        }

        if(formulaText.equals("States of Matter")){
            chapterName.setText("States of Matter");
            formulaSize = 26;
            formulaNames = chemStatesMatterNames;
            formulas = chemStatesMatter;
            formulaView();
        }

        if(formulaText.equals("Atomic Structure")){
            chapterName.setText("Atomic Structure");
            formulaSize = 16;
            formulaNames = chemAtomicStructNames;
            formulas = chemAtomicStruct;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Chemical Bonding & Mol. Structure")){
            chapterName.setText("Chemical Bonding & Mol. Structure");
            formulaSize = 4;
            formulaNames = chemBondingNames;
            formulas = chemBonding;
            formulaView();
        }

        if(formulaText.equals("Chemical Thermodynamics")){
            chapterName.setText("Chemical Thermodynamics");
            formulaSize = 19;
            formulaNames = chemThermodyNames;
            formulas = chemThermody;
            formulaView();
        }

        if(formulaText.equals("Solutions")){
            chapterName.setText("Solutions");
            formulaSize = 12;
            formulaNames = chemSolnsNames;
            formulas = chemSolns;
            formulaView();
        }

        if(formulaText.equals("Equilibrium")){
            chapterName.setText("Equilibrium");
            formulaSize = 9;
            formulaNames = chemEquilNames;
            formulas = chemEquil;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Redox Reactions & Electrochemistry")){
            chapterName.setText("Redox Reactions & Electrochemistry");
            formulaSize = 9;
            formulaNames = chemRedoxRxnNames;
            formulas = chemRedoxRxn;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Surface Chemistry")){
            chapterName.setText("Surfae Chemistry");
            formulaSize = 2;
            formulaNames = chemSurfaceNames;
            formulas = chemSurface;
            formulaView();
        }

        if(formulaText.equals("Classification of Elements")){
            chapterName.setText("Classification of Elements");
            formulaSize = 1;
            formulaNames = chemClassElemNames;
            formulas = chemClassElem;
            formulaView();
        }

        ///////////////////////////////////////////////////
        /////////////////////////////////////////////////// MATHS
        ///////////////////////////////////////////////////

        if(formulaText.equals("Sets")){
            chapterName.setText("Sets");
            formulaSize = 16;
            formulaNames = mathSetsNames;
            formulas = mathSets;
            formulaView();
        }

        if(formulaText.equals("Complex Numbers")){
            chapterName.setText("Complex Numbers");
            formulaSize = 12;
            formulaNames = mathComplexNoNames;
            formulas = mathComplexNo;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Quadratic Equations")){
            chapterName.setText("Quadratic Equations");
            formulaSize = 8;
            formulaNames = mathQuadEqnNames;
            formulas = mathQuadEqn;
            formulaView();
        }

        if(formulaText.equals("Matrices")){
            chapterName.setText("Matrices");
            formulaSize = 6;
            formulaNames = mathMatricesNames;
            formulas = mathMatrices;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Permutation & Combination")){
            chapterName.setText("Permutation & Combination");
            formulaSize = 16;
            formulaNames = mathPerAndComNames;
            formulas = mathPerAndCom;
            formulaView();
        }

        if(formulaText.equals("Binomial Theorem")){
            chapterName.setText("Binomial Theorem");
            formulaSize = 8;
            formulaNames = mathBinomialThoeNames;
            formulas = mathBinomialThoe;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Sequence & Series")){
            chapterName.setText("Sequence & Series");
            formulaSize = 17;
            formulaNames = mathSeqSeriesNames;
            formulas = mathSeqSeries;
            formulaView();
        }

        if(formulaText.equals("Statistics")){
            chapterName.setText("Statistics");
            formulaSize = 16;
            formulaNames = mathStatisticsNames ;
            formulas = mathStatistics;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Probability")){
            chapterName.setText("Probability");
            formulaSize = 12;
            formulaNames = mathProbabilityNames;
            formulas = mathProbability;
            formulaView();
        }

        if(formulaText.equals("Differential Calculus")){
            chapterName.setText("Differential Calculus");
            formulaSize = 12;
            formulaNames = mathDiffCalculusNames;
            formulas = mathDiffCalculus;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Straight Lines")){
            chapterName.setText("Straight Lines");
            formulaSize = 21;
            formulaNames = mathStLinesNames;
            formulas = mathStLines;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Circles")){
            chapterName.setText("Circles");
            formulaSize = 13;
            formulaNames = mathCirclesNames;
            formulas = mathCircles;
            formulaView();
        }

        if(formulaText.equals("Trigonometry")){
            chapterName.setText("Trigonometry");
            formulaSize = 26;
            formulaNames = mathTrigonoNames;
            formulas = mathTrigono;
            formulaView();
        }

        ///////////////////////////////////////////////////
        /////////////////////////////////////////////////// GENERAL
        ///////////////////////////////////////////////////

        if(formulaText.equals("Algebraic or Expansion Formulas")){
            chapterName.setText("Algebraic or Expansion Formulas");
            formulaSize = 11;
            formulaNames = genExpFormNames;
            formulas = genExpForm;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Some Tips & Trick for Quadratic Equation")){
            chapterName.setText("Some Tips & Trick for Quadratic Equation");
            formulaSize = 3;
            formulaNames = genQuadEqnNames;
            formulas = genQuadEqn;
            formulaView();
        }

        if(formulaText.equals("Basic Division Algorithm")){
            chapterName.setText("Basic Division Algorithm");
            formulaSize = 4;
            formulaNames = genDivAlgNames;
            formulas = genDivAlg;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Laws of Indices")){
            chapterName.setText("Laws of Indices");
            formulaSize = 10;
            formulaNames = genIndLawsNames;
            formulas = genIndLaws;
            formulaView();
        }

        if(formulaText.equals("Ratio & Proportion")){
            chapterName.setText("Ratio & Proportion");
            formulaSize = 6;
            formulaNames = genRatioPropNames;
            formulas = genRatioProp;
            formulaView();
        }

        if(formulaText.equals("Surface Measurement")){
            chapterName.setText("Surface Measurement");
            formulaSize = 4;
            formulaNames = genSurfMesNames;
            formulas = genSurfMes;
            formulaView();
            showInterstitialAd();
        }

        if(formulaText.equals("Conversions")){
            chapterName.setText("Conversions");
            formulaSize = 5;
            formulaNames = genConvNames;
            formulas = genConv;
            formulaView();
        }
        /////////////////////
        /////////////////////
        /////////////////////

    }

    private void formulaView(){

        formulaName = new ArrayList<String>();
        formula = new ArrayList<String>();
        looper();

        mRecyclerView=(RecyclerView) findViewById(R.id.formulaRec);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(Formulas.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerViewAdapter mAdapter=new RecyclerViewAdapter(Formulas.this, formulaName, this.formula);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void looper(){
        for(int i=0;i<formulaSize;i++){
            formulaName.add(formulaNames[i]);
            formula.add(formulas[i]);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (FormAdView != null) {
            FormAdView.pause();
            return;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (FormAdView != null) {
            FormAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (FormAdView != null) {
            FormAdView.destroy();
        }
        super.onDestroy();
    }

    private void showInterstitialAd(){
        formInterAd = new InterstitialAd(Formulas.this);
        formInterAd.setAdUnitId(getString(R.string.interstitial_ad));
        AdRequest interAdRequest = new AdRequest.Builder().build();
        formInterAd.loadAd(interAdRequest);
        formInterAd.setAdListener(new AdListener() {
            public void onAdLoaded(){
                //Toast.makeText(Formulas.this, "Click on the Ad to Unlock All the Formulas for Free", Toast.LENGTH_LONG).show();
                formInterAd.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}