1/Ajouter les variables ANDROID_HOME,MAVEN_HOME,JAVA_HOME sur eclipse:
window->preférence->substitution

2/Ajouter les templates sur eclipse:
Dans la fenêtre Préférences (Window > Préférences) :
    General > Workspace : Passer “Text file encoding” à UTF-8
    Java > Code Style > Code Templates : Importer le fichier “equalizer-template.xml” à partir du répertoire “eclipse” du projet
    Java > Code Style > Formatter : Importer le fichier “equalizer-formatting-rules.xml” à partir du répertoire “eclipse” du projet
    Java > Editor > Save Actions : Cocher “Perform the selected actions on save”; “Format source code” et “Format all lines”
    
3/Ajouter dans le fichier de configuration de maven:
<profiles>
    <profile>
        <id>android</id>
        <properties>
            <android.sdk.path>
              ANDROID SDK PATH
            </android.sdk.path>
        </properties>
    </profile>
</profiles>
<activeProfiles> <!--make the profile active all the time -->
    <activeProfile>android</activeProfile>
</activeProfiles> 

4/Pour lancer l'application:
run clean install
run android-deploy