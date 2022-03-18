
# Hospital Appointments System

Procedures required for the Hastane Randevu System application:

For example, you can think that you have 5 classes;
Hastane, Randevu, Hasta, Klinik, Doktor (these classes are just examples,
you can design the necessary programmatic in accordance with your application.
you should).
1. Appointments that can be made for the hastane and klinik whose name is entered.
   listing (such as hastane, klinik and doktor information in the relevant klinik)
2. The appointments from different kliniks that have been made so far
   listing
3. Listing all randevu information of the hasta with the most appointments
   (hasta information, hastane information, klinik information, randevu date, etc.).
   informations)
4. History and future appointments of the hasta whose name is entered
   listing
5. The hasta cancels the randevu at least 1 day before the randevu date.
   can. If less than 1 day is left, the randevu cannot be canceled or
   cannot be changed. If it is more than 1 day, it has taken
   can update the randevu.
6. Complex String search can be done. Name starting with *
   the hasta with 'widow' or 'hme' and ending with 't', or
   hastas' randevu information (past and future appointments)
   writes to the screen
   (Note: * can be any letter, upper or lower case does not matter)
7. Clinical deletion
   • Future randevu by any hasta for the klinik to be deleted
   should not have been received. If there is information, clinical deletion process
   should not be done
   • If no randevu has been made from the klinik to be deleted
   (future randevu) the relevant klinik should be deleted and
   no more appointments should be made for this klinik in the hastane.
8. Ability to delete doktor
   • An active randevu with the doktor to be deleted or the corresponding doktor in the future
   If there is no randevu made, this doktor can be deleted. If any, information is given
   these active appointments or appointments are randomly assigned to other doktor(s)
   should be assigned. If you make an randevu for the klinik where the doktor works in the system
   deletion if there is no other doktor to be assigned (if there is no randevu conflict)
   operation should not be done. If there is another doktor who can be assigned an randevu
   deletion should be done and previous appointments of this deleted doktor
   It should be added to the "old Appointments" list and kept.
9. Caring for the most hastas on the entered date (within the Randevu class)
   randevu status information should be kept) listing the doktor's information.
10. Information of hastas with the most appointments on a clinical basis
    listing.
11. On the basis of the entered hastane, the average taken for each klinik, the maximum
    and listing the minimum number of appointments (klinik z at hastane X
    The maximum, average, minimum number of appointments for hastane X is
    The maximum, average, minimum number of appointments for klinik b is as follows)
12. All completed appointments between the given dates
    listing
13. All incomplete/future
    listing of appointments. Customer information who received the relevant randevu,
    clinical information, doktor information, hastane information, randevu date, etc.
    information should be listed.
