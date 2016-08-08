package vol.model.dao;

import vol.model.CompagnieAerienneVol;

public interface CompagnieAerienneVolDao extends Dao<CompagnieAerienneVol, Integer> {

	CompagnieAerienneVol findById(Integer id);

}
