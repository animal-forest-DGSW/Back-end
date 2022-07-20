package kr.hs.dgsw.AnimalForest.repository;

import kr.hs.dgsw.AnimalForest.damain.Board;
import kr.hs.dgsw.AnimalForest.damain.enum_package.Classification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findByTitleContainingAndClassification(String title, Classification classification, Pageable pageable);
    public List<Board> findByTitleContaining(String title, Pageable pageable);
}
